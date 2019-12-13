package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deo_login extends AppCompatActivity {

    private Button reg;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deo_login);
        reg = (Button) findViewById(R.id.button_register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(deo_login.this, deo_reg.class);
                startActivity(i);
            }
        });
        reg = (Button) findViewById(R.id.button_login);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(deo_login.this, deo_update.class);
                startActivity(i);
            }
        });
    }
}
