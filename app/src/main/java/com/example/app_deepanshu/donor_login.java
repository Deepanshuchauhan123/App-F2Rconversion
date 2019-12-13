package com.example.app_deepanshu;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donor_login extends AppCompatActivity {
    private Button donorreg;
    private Button donorsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);
        donorreg = (Button) findViewById(R.id.button_register);
        donorreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(donor_login.this, donor_reg.class);
                startActivity(i1);
            }
        });
        donorsubmit = (Button) findViewById(R.id.button_login);
        donorsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(donor_login.this,donor_selcet.class);
                startActivity(i);
            }
        });
    }
}
