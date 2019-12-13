package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;


public class teacher_reg extends AppCompatActivity implements View.OnClickListener {

    ProgressBar simpleProgressBar;
    EditText email1,password,sch_name,teach_name,teacher_sub,teach_mobile,teach_area,teach_state;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        email1 = findViewById(R.id.teacher_email);
        password=findViewById(R.id.teacher_password);
        sch_name=findViewById(R.id.school_name);
        teach_name=findViewById(R.id.teacher_name);
        teacher_sub=findViewById(R.id.teacher_subject);
        teach_mobile=findViewById(R.id.teacher_mobile);
        teach_area=findViewById(R.id.teacher_village);
        teach_state=findViewById(R.id.teacher_state);



        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.button_submit).setOnClickListener(this);

    }


    private void teacher_signup(){

        String email= email1.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String sch_name1 = sch_name.getText().toString().trim();
        String sub1 = teacher_sub.getText().toString().trim();
        String name1= teach_name.getText().toString().trim();
        String mob1 = teach_mobile.getText().toString().trim();
        String area1= teach_area.getText().toString().trim();
        String state1= teach_state.getText().toString().trim();

        //Email
        if (!Patterns.EMAIL_ADDRESS .matcher(email).matches()) {
            email1.setError("Email is Wrong");
            email1.requestFocus();
            return;
        }

        //for Password
        if (pass1.length() < 6) {
            password.setError("Minimum length of Password is 6");
            password.requestFocus();
            return;
        }

        //for phone
        if (mob1.isEmpty()) {
            teach_mobile.setError("Phone is Required");
            teach_mobile.requestFocus();
            return;
        }

        if (mob1.length() != 10) {
            teach_mobile.setError("Length Exceeds");
            teach_mobile.requestFocus();
            return;
        }

        //for school name
        if (sch_name1.isEmpty()) {
            sch_name.setError("School Name is required");
            sch_name.requestFocus();
            return;
        }

        if (sub1.isEmpty()) {
            teacher_sub.setError("school  id is required");
            teacher_sub.requestFocus();
            return;
        }
        //for name
        if (name1.isEmpty()) {
            teach_name.setError("Teacher Name is Required");
            teach_name.requestFocus();
            return;
        }

        //for area
        if (area1.isEmpty()) {
            teach_area.setError("Teacher Area is Required");
            teach_area.requestFocus();
            return;
        }

        if (state1.isEmpty()) {
            teach_state.setError("State is required");
            teach_state.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    teacher teach = new teacher(
                            email1.getText().toString(),
                            sch_name.getText().toString(),
                            teach_name.getText().toString(),
                            teacher_sub.getText().toString(),
                            teach_mobile.getText().toString(),
                            teach_area.getText().toString(),
                            teach_state.getText().toString()
                    );
                    FirebaseDatabase.getInstance().getReference("Teacher_portal")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(teach).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                simpleProgressBar.setVisibility(View.VISIBLE);
                                Toast.makeText(teacher_reg.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(teacher_reg.this,first_cat.class));
                            } else {
                                //display a failure message
                                Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {

                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_submit:
                teacher_signup();
                break;
        }

    }
}
