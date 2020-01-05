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

import com.example.app_deepanshu.api.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class first_cat extends AppCompatActivity implements View.OnClickListener {

    EditText aadhar, password;
   // private FirebaseAuth mAuth;
    ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_cat);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);


        aadhar = findViewById(R.id.edittext_adhaar);
        password = findViewById(R.id.edittext_password);
       // mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.button_register1).setOnClickListener(this);

        findViewById(R.id.button_login).setOnClickListener(this);
        findViewById(R.id.edittext_password).setOnClickListener(this);

    }

    private void teacher_login() {
        String username = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        if (username.isEmpty()) {
            aadhar.setError("ईमेल अनिवार्य है!");
            aadhar.requestFocus();
            return;
        }

        //for Password
        if (pass1.isEmpty()) {
            password.setError("पासवर्ड अनिवार्य है!");
            password.requestFocus();
            return;
        }
        if (pass1.length() < 6) {
            password.setError("Minimum length of Password is 6");
            password.requestFocus();
            return;
        }

        Call<stu_login> call= RetrofitClient
                .getInstance().getApi().teacherLogin(username,pass1);
        call.enqueue(new Callback<stu_login>() {
            @Override
            public void onResponse(Call<stu_login> call, Response<stu_login> response) {

                if (response.isSuccessful()) {
                    simpleProgressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(first_cat.this, teacher_grid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    simpleProgressBar.setVisibility(View.VISIBLE);

                } else {

                    Toast.makeText(first_cat.this,"Invalid User Credential",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<stu_login> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

//        mAuth.signInWithEmailAndPassword(adhar1, pass1).addOnCompleteListener(first_cat.this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful())
//                {
//                    simpleProgressBar.setVisibility(View.VISIBLE);
//                    Intent intent = new Intent(first_cat.this, teacher_grid.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//                    finish();
//
//                } else {
//                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_login:
                teacher_login();
                break;

            case R.id.button_register1:

                Intent i = new Intent(first_cat.this, teacher_reg.class);
                startActivity(i);
                break;
        }
    }
}



