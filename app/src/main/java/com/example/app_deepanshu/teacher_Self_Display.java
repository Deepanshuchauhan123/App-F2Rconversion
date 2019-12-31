package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class teacher_Self_Display extends AppCompatActivity {
private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__self__display);

        mRecyclerView= (RecyclerView)findViewById(R.id.recyclerview_subjects);
        new FirebaseDatabaseHelper().readSubjects(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataisLoaded(List<teacher> subjects, List<String> keys)
            {
                new RecyclerView_Config().setConfig(mRecyclerView,teacher_Self_Display.this,subjects,keys);
            }

            @Override
            public void DataIsInserted() {

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
