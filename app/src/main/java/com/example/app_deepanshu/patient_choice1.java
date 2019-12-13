package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class patient_choice1 extends AppCompatActivity {
private Button enq;
private Button emergency;
private Button status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_choice1);
        enq = (Button) findViewById(R.id.enq);
        enq.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(patient_choice1.this, hospital_enquiry.class);
                startActivity(i);

            }
        });
        emergency = (Button) findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(patient_choice1.this, emergency.class);
                startActivity(i);

            }
        });
        status = (Button) findViewById(R.id.doctor);
        status.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(patient_choice1.this, doctor_avail.class);
                startActivity(i);

            }
        });
    }
}
