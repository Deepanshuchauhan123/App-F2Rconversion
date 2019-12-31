package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;

public class Add_Student extends AppCompatActivity {
    private Spinner classes,stream;
    int c,s;
    public static String citem;
    public String sitem;
    private EditText batch;
    private EditText name;
    private EditText father_name;
    private EditText adhaar;
    private Button submit;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);
        classes  = (Spinner) findViewById(R.id.classes);
        stream  = (Spinner) findViewById(R.id.stream);
        batch=(EditText) findViewById(R.id.student_batch);
        name=(EditText) findViewById(R.id.student_name);
        father_name=(EditText) findViewById(R.id.student_father);
        adhaar=(EditText) findViewById(R.id.student_adhaar);
        submit=(Button) findViewById(R.id.button_submit);
        back=(Button) findViewById(R.id.button_back);
        classes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                citem = parent.getItemAtPosition(position).toString();
                c=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {   sitem = parent.getItemAtPosition(position).toString();
                s=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (c == 0) {
                    Toast.makeText(Add_Student.this, "Enter a valid class", Toast.LENGTH_SHORT).show();
                }
                else
                if(s==0)
                {
                    Toast.makeText(Add_Student.this, "Enter a valid Stream", Toast.LENGTH_SHORT).show();
                }
                else
                if(c==7  && s==5)
                {
                    Toast.makeText(Add_Student.this, "You should chooose a stream", Toast.LENGTH_SHORT).show();
                }
                else
                if(c==8 && s==5)
                {
                    Toast.makeText(Add_Student.this, "You should chooose a stream", Toast.LENGTH_SHORT).show();
                }

                else {
                    Student_model student = new Student_model();
                    student.setBatch(batch.getText().toString());
                    student.setFather_Name(father_name.getText().toString());
                    student.setStudent_Adhaar(adhaar.getText().toString());
                    student.setStudent_Name(name.getText().toString());
                    student.setStudent_Class(classes.getSelectedItem().toString());
                    student.setStream(stream.getSelectedItem().toString());

                    new FirebaseDatabaseHelper().addStudent(student, new FirebaseDatabaseHelper.DataStatus() {
                        @Override
                        public void DataisLoaded(List<teacher> subjects, List<String> keys) {

                        }

                        @Override
                        public void DataIsInserted() {
                            Toast.makeText(Add_Student.this, "Student is Added Successfully"
                                    , Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void DataIsUpdated() {

                        }

                        @Override
                        public void DataIsDeleted() {

                        }
                    });
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();return;
            }
        });
    }
}
