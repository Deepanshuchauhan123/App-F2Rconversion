package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class teacher_self_grid extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_self_grid);

        button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(teacher_self_grid.this, Teacher_self_Detail.class);
                startActivity(i);
            }
        });
        button2 = (Button) findViewById(R.id.self_display);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i1 = new Intent(teacher_self_grid.this, teacher_Self_Display.class);
                startActivity(i1);
            }
        });
    }
}
