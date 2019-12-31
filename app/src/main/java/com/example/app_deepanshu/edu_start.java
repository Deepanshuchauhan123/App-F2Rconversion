package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class edu_start extends AppCompatActivity
{
    private Button teacherbutton;
    private Button studentbutton;
    private Button parentsbutton;
    private Button schoolbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_start);
        studentbutton = (Button) findViewById(R.id.studentss);
        studentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(edu_start.this, student_login.class);
                startActivity(in);
            }
        });
        teacherbutton = (Button) findViewById(R.id.teacher);
        teacherbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(edu_start.this, first_cat.class);
                startActivity(i);
            }
        });

        parentsbutton = (Button) findViewById(R.id.parents);
        parentsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(edu_start.this, parents_login.class);
                startActivity(i);
            }
        });
        schoolbutton = (Button) findViewById(R.id.school);
        schoolbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(edu_start.this, School_login.class);
                startActivity(i);
            }
        });
    }
}