package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class student_login extends AppCompatActivity implements View.OnClickListener{


    EditText aadhar,password;
//    private FirebaseAuth mAuth;
    ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        aadhar = findViewById(R.id.edittext_adhaar);
        password = findViewById(R.id.edittext_password);

      //  mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.button_register).setOnClickListener(this);

        findViewById(R.id.button_login).setOnClickListener(this);
    }
    private static String token;
    private void student_login()
    {
        String adhar1 = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        //aadhar
        if (adhar1.isEmpty()) {
            aadhar.setError("Aadhar is Required");
            aadhar.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS .matcher(adhar1).matches()) {
            aadhar.setError("Enter Valid Name");
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

        Call<StudentLoginResponse> call= RetrofitClient
                .getInstance().getApi().userLogin(adhar1,pass1);


        call.enqueue(new Callback<StudentLoginResponse>() {
            @Override
            public void onResponse(Call<StudentLoginResponse> call, Response<StudentLoginResponse> response) {
            StudentLoginResponse studentLoginResponse=response.body();

            if(!studentLoginResponse.isError()){

                Toast.makeText(student_login.this,studentLoginResponse.getMessage(),Toast.LENGTH_LONG).show();
                token=studentLoginResponse.getToken();
            }else {
                Toast.makeText(student_login.this,studentLoginResponse.getMessage(),Toast.LENGTH_LONG).show();
            }
            }
            @Override
            public void onFailure(Call<StudentLoginResponse> call, Throwable t) {

            }
        });



//        mAuth.signInWithEmailAndPassword(adhar1,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent = new Intent(student_login.this, student_grid.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    simpleProgressBar.setVisibility(View.VISIBLE);
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
                student_login();
                break;
            case R.id.button_register:
                Intent i = new Intent(student_login.this, student_reg.class);
                startActivity(i);
                break;
        }

    }
}