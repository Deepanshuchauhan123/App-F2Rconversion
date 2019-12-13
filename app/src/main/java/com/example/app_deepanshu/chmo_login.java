package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chmo_login extends AppCompatActivity {
private Button reg;
private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chmo_login);
        reg = (Button) findViewById(R.id.button_register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(chmo_login.this, chmo_reg.class);
                startActivity(i);
            }
        });
        login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(chmo_login.this, chmo_update.class);
                startActivity(i);
            }
        });
    }
}
