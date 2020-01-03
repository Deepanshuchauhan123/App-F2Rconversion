package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class parents_reg extends AppCompatActivity implements View.OnClickListener {

   // FirebaseAuth mAuth;

    EditText email1,password,parent_name,prnt_mobile,prnt_area,prnt_state,adhaar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_reg);

      //  mAuth = FirebaseAuth.getInstance();


        email1 = findViewById(R.id.parent_email);
        adhaar=findViewById(R.id.parent_adhaar);
        parent_name=findViewById(R.id.parent_Name);
        password=findViewById(R.id.parent_password);
        prnt_mobile=findViewById(R.id.parent_mobile);
        prnt_area=findViewById(R.id.parent_village);
        prnt_state=findViewById(R.id.parent_state);


        findViewById(R.id.button_submit).setOnClickListener(this);

    }

    private void parent_signup(){


        String email= email1.getText().toString().trim();
        String adhaar1= adhaar.getText().toString().trim();
        String prnt_name1 = parent_name.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String mob1 = prnt_mobile.getText().toString().trim();
        String area1= prnt_area.getText().toString().trim();
        String state1= prnt_state.getText().toString().trim();


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
            prnt_mobile.setError("Phone is Required");
            prnt_mobile.requestFocus();
            return;
        }

        if (mob1.length() != 10) {
            prnt_mobile.setError("Length Exceeds");
            prnt_mobile.requestFocus();
            return;
        }


        //for name
        if (prnt_name1.isEmpty()) {
            parent_name.setError(" Name is Required");
            parent_name.requestFocus();
            return;
        }

        //for area
        if (area1.isEmpty()) {
            prnt_area.setError("Teacher Area is Required");
            prnt_area.requestFocus();
            return;
        }

        //for state
        if (state1.isEmpty()) {
            prnt_state.setError("State is required");
            prnt_state.requestFocus();
            return;
        }

        //for Occupation
        if (adhaar1.isEmpty()) {
            adhaar.setError("Enter Your Occupation");
            adhaar.requestFocus();
            return;
        }

        Call<DefaultResponse> call= RetrofitClient.getInstance()
                .getApi()
                .createParent(adhaar1,pass1,email,
                        prnt_name1,
                        mob1,area1,state1);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr=response.body();
                    Toast.makeText(parents_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(parents_reg.this,"User Already Exist",Toast.LENGTH_LONG).show();
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
//                    Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(parents_reg.this,parents_login.class));
//                    parents Parents_Portal= new parents(
//                            email1.getText().toString(),
//                            adhaar.getText().toString(),
//                            parent_name.getText().toString(),
//                            prnt_mobile.getText().toString(),
//                            prnt_area.getText().toString(),
//                            prnt_state.getText().toString()
//
//                    );
//                    FirebaseDatabase.getInstance().getReference("Parents_Portal")
//                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                            .setValue(Parents_Portal).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(parents_reg.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(parents_reg.this,parents_login.class));
//                            } else {
//                                //display a failure message
//                                Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//
//                }
//                else {
//                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
//                        Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_submit:
                parent_signup();
                break;
        }

    }
}