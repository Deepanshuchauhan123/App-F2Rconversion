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

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class School_Reg extends AppCompatActivity implements View.OnClickListener {

    ProgressBar simpleProgressBar;
    public String key;
    EditText email1,password,school_teach_key,sch_name,board_name,school_key,schl_mobile,scl_location,school_state,cnf_pass;
   // private FirebaseAuth mAuth;
    public String school_Verify_Key="hello";
    private Button btn,btn1;
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
        school_teach_key=findViewById(R.id.Generate_key);
        schl_mobile=findViewById(R.id.school_mobile);
        scl_location=findViewById(R.id.school_location);
        school_state=findViewById(R.id.school_state);

        btn=(Button)findViewById(R.id.verify_btn);
        btn1=(Button)findViewById(R.id.button_submit);
        findViewById(R.id.after_verify).setVisibility(View.GONE);
        findViewById(R.id.hai_jo_hai).setVisibility(View.VISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                key = school_key.getText().toString().trim();
                if(key.equalsIgnoreCase(school_Verify_Key))
                {
                    findViewById(R.id.after_verify).setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Key Matched Sucessfully ",Toast.LENGTH_LONG).show();
                    findViewById(R.id.hai_jo_hai).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.after_verify).setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Enter a valid Key",Toast.LENGTH_LONG).show();
                }
                if (key.isEmpty()) {
                    school_key.setError("school  id is required");
                    school_key.requestFocus();
                    return;
                }

            }
        });
        findViewById(R.id.button_submit).setOnClickListener(this);
    }

    public void School_signup(){

        String email= email1.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String sch_name1 = sch_name.getText().toString().trim();
        String key = school_key.getText().toString().trim();
        String key_teach=school_teach_key.getText().toString().trim();
        String board= board_name.getText().toString().trim();
        String mob1 = schl_mobile.getText().toString().trim();
        String confirmpass=cnf_pass.getText().toString().trim();
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
        if(!pass1.equals(confirmpass)){
            cnf_pass.setError("Password and Confirm password should match");
            cnf_pass.requestFocus();
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

        if (key_teach.isEmpty()) {
            school_teach_key.setError("school  id is required");
            school_teach_key.requestFocus();
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

        Call<DefaultResponse> call= RetrofitClient.getInstance()
                .getApi()
                .createSchool(key_teach,pass1,email,
                        sch_name1,mob1,area1,
                        state1,board);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr=response.body();
                    Toast.makeText(School_Reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(School_Reg.this,School_login.class));
                }else {
                    Toast.makeText(School_Reg.this,"User Already Exist",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });




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

        }
    }
}