package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class School_Reg extends AppCompatActivity implements View.OnClickListener {

    ProgressBar simpleProgressBar;
    EditText email1,password,sch_name,board_name,school_key,schl_mobile,scl_location,school_state,cnf_pass;
   // private FirebaseAuth mAuth;
    private String school_Verify_Key="18EMCCS031";
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__reg);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        email1 = findViewById(R.id.school_email);
        password=findViewById(R.id.school_password);
        cnf_pass=findViewById(R.id.villager_cnf_password);
        sch_name=findViewById(R.id.school_name);
        board_name=findViewById(R.id.school_board);
        school_key=findViewById(R.id.school_key);
        schl_mobile=findViewById(R.id.school_mobile);
        scl_location=findViewById(R.id.school_location);
        school_state=findViewById(R.id.school_state);

        btn=findViewById(R.id.button_submit);
        //findViewById(R.id.after_vrify).setVisibility(View.INVISIBLE);

//            email1.setVisibility(View.INVISIBLE);
//            password.setVisibility(View.INVISIBLE);
//            sch_name.setVisibility(View.INVISIBLE);
//            schl_mobile.setVisibility(View.INVISIBLE);
//            scl_location.setVisibility(View.INVISIBLE);
//            school_state.setVisibility(View.INVISIBLE);
//            cnf_pass.setVisibility(View.INVISIBLE);
//            btn.setVisibility(View.INVISIBLE);

       // mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.button_submit).setOnClickListener(this);

        findViewById(R.id.verify_btn).setOnClickListener(this);

    }
    private void school_Verify() {
        school_key=findViewById(R.id.school_key);
        String key = school_key.getText().toString().trim();
        if (key.isEmpty()) {
            school_key.setError("school  id is required");
            school_key.requestFocus();
            return;
        }
        if(key==school_Verify_Key)
        {
            findViewById(R.id.after_vrify).setVisibility(View.INVISIBLE);
//            email1.setVisibility(View.VISIBLE);
//            password.setVisibility(View.VISIBLE);
//            sch_name.setVisibility(View.VISIBLE);
//            schl_mobile.setVisibility(View.VISIBLE);
//            scl_location.setVisibility(View.VISIBLE);
//            school_state.setVisibility(View.VISIBLE);
//            cnf_pass.setVisibility(View.VISIBLE);
//            btn.setVisibility(View.VISIBLE);
        }

    }

    public void School_signup(){

        String email= email1.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String sch_name1 = sch_name.getText().toString().trim();
        String key = school_key.getText().toString().trim();
        String board= board_name.getText().toString().trim();
        String mob1 = schl_mobile.getText().toString().trim();
        String area1= scl_location.getText().toString().trim();
        String state1= school_state.getText().toString().trim();

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
            schl_mobile.setError("Phone is Required");
            schl_mobile.requestFocus();
            return;
        }

        if (mob1.length() != 10) {
            schl_mobile.setError("Length Exceeds");
            schl_mobile.requestFocus();
            return;
        }

        //for school name
        if (sch_name1.isEmpty()) {
            sch_name.setError("School Name is required");
            sch_name.requestFocus();
            return;
        }

        if (key.isEmpty()) {
            school_key.setError("school  id is required");
            school_key.requestFocus();
            return;
        }
        //for name
        if (board.isEmpty()) {
            board_name.setError("Teacher Name is Required");
            board_name.requestFocus();
            return;
        }

        //for area
        if (area1.isEmpty()) {
            scl_location.setError("Teacher Area is Required");
            scl_location.requestFocus();
            return;
        }

        if (state1.isEmpty()) {
            school_state.setError("State is required");
            school_state.requestFocus();
            return;
        }

//        mAuth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    school s = new school(
//                            email1.getText().toString(),
//                            sch_name.getText().toString(),
//                            board_name.getText().toString(),
//                            school_key.getText().toString(),
//                            schl_mobile.getText().toString(),
//                            scl_location.getText().toString(),
//                            school_state.getText().toString()
//                    );
//
//
//                    //help_key=school_key.getText().toString();
//
//                    FirebaseDatabase.getInstance().getReference("School_portal")
//                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                            .setValue(s).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                simpleProgressBar.setVisibility(View.VISIBLE);
//                                Toast.makeText(School_Reg.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(School_Reg.this,School_login.class));
//                                finish();return;
//                            } else {
//                                //display a failure message
//                                Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                } else {
//                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_submit:
                School_signup();
                break;
            case R.id.verify_btn:
                school_Verify();
                break;
        }
    }
}