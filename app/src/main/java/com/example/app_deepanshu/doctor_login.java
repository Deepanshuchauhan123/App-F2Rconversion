package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class doctor_login extends AppCompatActivity {
private Button mbuttonregister;
private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        mbuttonregister = (Button) findViewById(R.id.patient_reg);
        mbuttonregister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(doctor_login.this, doctor_reg.class);
                startActivity(i);

            }
        });
        login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(doctor_login.this, Doctor_main.class);
                startActivity(i);
            }
        });
    }
}
