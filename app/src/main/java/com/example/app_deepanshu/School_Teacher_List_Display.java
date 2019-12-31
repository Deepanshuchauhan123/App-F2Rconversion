package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class School_Teacher_List_Display extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__teacher__list__display);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_teachers);
        new firebaseDatabaseHelpers().readteachers(new firebaseDatabaseHelpers.DataStatus() {
            @Override
            public void DataIsLoaded(List<teachers> teachs, List<String> keys) {
                new RecyclerView_teacher().setConfig(mRecyclerView,School_Teacher_List_Display.this,
                        teachs,keys);
            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}