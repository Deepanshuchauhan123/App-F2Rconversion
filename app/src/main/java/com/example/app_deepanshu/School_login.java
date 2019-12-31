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

public class School_login extends AppCompatActivity implements View.OnClickListener {

    EditText aadhar, password;
    private FirebaseAuth mAuth;
    ProgressBar simpleProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_login);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);


        aadhar = findViewById(R.id.edittext_adhaar);
        password = findViewById(R.id.edittext_password);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button_register).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);
        findViewById(R.id.edittext_password).setOnClickListener(this);
    }

    private void school_login() {
        String adhar1 = aadhar.getText().toString().trim();
        String pass1 = password.getText().toString().trim();

        if (adhar1.isEmpty()) {
            aadhar.setError("ईमेल अनिवार्य है!");
            aadhar.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(adhar1).matches()) {
            aadhar.setError("उपयुक्त ईमेल डाले ");
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

        mAuth.signInWithEmailAndPassword(adhar1, pass1).addOnCompleteListener(School_login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    simpleProgressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(School_login.this, school_main_grid.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_login:
                school_login();
                break;

            case R.id.button_register:
                Intent i = new Intent(School_login.this, School_Reg.class);
                startActivity(i);
                break;
        }
    }
}
