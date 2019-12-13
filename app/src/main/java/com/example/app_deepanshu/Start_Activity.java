package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_Activity extends AppCompatActivity {

    private Button mButtonhealth;
    private Button mButtoneducation;
    private Button mButtonAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);

        //mButtonLogin =(Button)findViewById(R.id.button_login);
        mButtonhealth = (Button) findViewById(R.id.button_health);
        mButtonhealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, health_cat.class);
                startActivity(i);

            }
        });
        mButtoneducation = (Button) findViewById(R.id.button_education);
        mButtoneducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, edu_start.class);
                startActivity(i);

            }
        });
        mButtonAdmin = (Button) findViewById(R.id.button_duty);
        mButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Start_Activity.this, admin_chart.class);
                startActivity(i);

            }
        });


    }
}
