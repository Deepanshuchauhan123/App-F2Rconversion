package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class student_reg extends AppCompatActivity implements View.OnClickListener{

    EditText student_email,student_name,student_parents,student_adhaar,father_adhaar,student_password,student_mobile,student_add,student_state;
   // private FirebaseAuth mAuth;
    ProgressBar simpleProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        student_email = findViewById(R.id.student_email);
        student_name=findViewById(R.id.student_name);
        student_parents=findViewById(R.id.student_parents);
        student_adhaar=findViewById(R.id.student_adhaar);
        father_adhaar=findViewById(R.id.father_adhaar);
        student_password=findViewById(R.id.student_password);
        student_mobile=findViewById(R.id.student_mobile);
        student_add=findViewById(R.id.student_add);
        student_state=findViewById(R.id.student_state);

//        mAuth = FirebaseAuth.getInstance();
          findViewById(R.id.button_submit).setOnClickListener((View.OnClickListener)this);

    }

    private void student_signup(){

        String emails= student_email.getText().toString().trim();
        String name = student_name.getText().toString().trim();
        String parent_name = student_parents.getText().toString().trim();
        String stu_adhaar = student_adhaar.getText().toString().trim();
        String fat_adhaar= father_adhaar.getText().toString().trim();
        String pass = student_password.getText().toString().trim();
        String mobile= student_mobile.getText().toString().trim();
        String add= student_add.getText().toString().trim();
        String state= student_state.getText().toString().trim();
        //Email
        if (!Patterns.EMAIL_ADDRESS .matcher(emails).matches()) {
            student_email.setError("Email is Wrong");
            student_email.requestFocus();
            return;
        }

        //for Password
        if (pass.length() < 6) {
            student_password.setError("Minimum length of Password is 6");
            student_password.requestFocus();
            return;
        }

        //for phone
        if (mobile.isEmpty()) {
            student_mobile.setError("Phone is Required");
            student_mobile.requestFocus();
            return;
        }

        if (mobile.length() != 10) {
            student_mobile.setError("Length Exceeds");
            student_mobile.requestFocus();
            return;
        }

        //for school name
        if (name.isEmpty()) {
            student_name.setError("Required");
            student_name.requestFocus();
            return;
        }

        if (parent_name.isEmpty()) {
            student_parents.setError("Required");
            student_parents.requestFocus();
            return;
        }
        //for name
        if (stu_adhaar.isEmpty()) {
            student_adhaar.setError("Required");
            student_adhaar.requestFocus();
            return;
        }

        //for area
        if (fat_adhaar.isEmpty()) {
            father_adhaar.setError("Required");
            father_adhaar.requestFocus();
            return;
        }

        //for state
        if (add.isEmpty()) {
            student_add.setError("Required");
            student_add.requestFocus();
            return;
        }
        if (state.isEmpty()) {
            student_state.setError("Required");
            student_state.requestFocus();
            return;
        }

        Call<DefaultResponse> call= RetrofitClient.getInstance()
                .getApi()
                .createUser(stu_adhaar,pass,emails,
                        name,parent_name,fat_adhaar,
                        mobile,add,state);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr=response.body();
                    Toast.makeText(student_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(student_reg.this,"User Already Exist",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }
//        mAuth.createUserWithEmailAndPassword(emails,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    student student = new student(
//                            student_email.getText().toString(),
//                            student_name.getText().toString(),
//                            student_parents.getText().toString(),
//                            student_adhaar.getText().toString(),
//                            father_adhaar.getText().toString(),
//                            student_mobile.getText().toString(),
//                            student_add.getText().toString(),
//                            student_state.getText().toString()
//
//                    );
//                    FirebaseDatabase.getInstance().getReference("Student_Portal")
//                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                            .setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                simpleProgressBar.setVisibility(View.VISIBLE);
//                                Toast.makeText(student_reg.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(student_reg.this,student_login.class));
//                            } else {
//                                //display a failure message
//                                Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//
//                } else {
//
//                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


@Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_submit:
                student_signup();
                break;
        }

    }
}