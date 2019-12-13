package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Sarpanch_main extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarpanch_main);

        spinner = findViewById(R.id.spinner_Admin);

        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(Sarpanch_main.this, R.array.admin, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(Sarpanch_main.this);
    }

    @Override
    public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id)
    {
        String item = parent.getItemAtPosition(position).toString();
        // show selected spinner item
        //Toast.makeText(parent.getContext(), "\n" +"Enter details " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}