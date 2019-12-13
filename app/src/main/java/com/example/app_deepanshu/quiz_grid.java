package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class quiz_grid extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_grid);

        one = (Button) findViewById(R.id.btn1);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(quiz_grid.this, student_quiz.class);
                startActivity(i);
            }
        });
        two = (Button) findViewById(R.id.btn2);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(quiz_grid.this, student_quiz.class);
                startActivity(i);
            }
        });
        three = (Button) findViewById(R.id.btn3);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(quiz_grid.this, student_quiz.class);
                startActivity(i);
            }
        });
        four = (Button) findViewById(R.id.btn4);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(quiz_grid.this, student_quiz.class);
                startActivity(i);
            }
        });

    }
    }
