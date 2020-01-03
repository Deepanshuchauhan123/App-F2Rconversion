package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class parents_login extends AppCompatActivity implements View.OnClickListener{

    EditText aadhar,password;
   // private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_login);


        aadhar = findViewById(R.id.edittext_adhaar);
        password = findViewById(R.id.edittext_password);
       // mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button_register).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);


    }

    private void parent_login()
    {
        String adhar1 = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        //aadhar
        if (adhar1.isEmpty()) {
            aadhar.setError("Email is Required");
            aadhar.requestFocus();
            return;
        }

        //for Password
        if (pass1.isEmpty()) {
            password.setError("Password Required");
            password.requestFocus();
            return;
        }
        if (pass1.length() < 6) {
            password.setError("Minimum length of Password is 6");
            password.requestFocus();
            return;
        }
        Call<stu_login> call= RetrofitClient
                .getInstance().getApi().parentLogin(adhar1,pass1);
        call.enqueue(new Callback<stu_login>() {
            @Override
            public void onResponse(Call<stu_login> call, Response<stu_login> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(parents_login.this,"Login Sucessful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(parents_login.this, parents_grid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {

                    Toast.makeText(parents_login.this,"Invalid User Credential",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<stu_login> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
//        mAuth.signInWithEmailAndPassword(adhar1,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent = new Intent(parents_login.this, parents_grid.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                parent_login();
                break;
            case R.id.button_register:
                Intent i = new Intent(parents_login.this, parents_reg.class);
                startActivity(i);
                break;
        }

    }
}