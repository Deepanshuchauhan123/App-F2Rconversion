package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class teacher_assignment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_assignment);
    Button btn_filePicker;
    Spinner spinner;
    TextView txt_pathShow;
        spinner = findViewById(R.id.classspin);

        ArrayAdapter<CharSequence> adapter1= (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(teacher_assignment.this,R.array.Class_Names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(teacher_assignment.this);
        txt_pathShow = (TextView) findViewById(R.id.edit3);
        btn_filePicker = (Button)findViewById(R.id.btn_filePicker);
        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myfileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                myfileIntent.setType("*/*");
                startActivityForResult(myfileIntent,10);
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

