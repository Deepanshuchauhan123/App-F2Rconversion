package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class school_main_grid extends AppCompatActivity {
    private DatabaseReference mRef;
private Button bteachers;
public static String value="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_main_grid);
        bteachers=(Button)findViewById(R.id.school_teachers);
       bteachers.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(school_main_grid.this,School_Teacher_List_Display.class);
               startActivity(i);
           }
       });
    }

    public school_main_grid() {
        mRef = FirebaseDatabase.getInstance()
                .getReference("School_portal").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        mRef.child("School_Verify_Key").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                value = snapshot.getValue().toString();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
