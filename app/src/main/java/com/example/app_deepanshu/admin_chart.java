package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_chart extends AppCompatActivity {
    private Button chmo;
    private Button collector;
    private Button deo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chart);
        chmo = (Button) findViewById(R.id.cmho);
        chmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(admin_chart.this, chmo_login.class);
                startActivity(i);
            }
        });
        collector = (Button) findViewById(R.id.collector);
        collector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(admin_chart.this, collector_login.class);
                startActivity(i);
            }
        });
        deo = (Button) findViewById(R.id.deo);
        deo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(admin_chart.this, deo_login.class);
                startActivity(i);
            }
        });

        deo = (Button) findViewById(R.id.sarpanch);
        deo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(admin_chart.this, Sarpanch_login.class);
                startActivity(i);
            }
        });
    }
}
