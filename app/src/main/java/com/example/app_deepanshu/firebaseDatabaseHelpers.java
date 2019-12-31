package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class firebaseDatabaseHelpers extends school_main_grid {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private Query mReferenceteachers;
    private static final String TAG = "firebaseDatabaseHelpers";
        private List<teachers> teachs =new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<teachers> teachs,List<String> keys);
        void DataIsDeleted();
    }

    public firebaseDatabaseHelpers() {

        mDatabase =FirebaseDatabase.getInstance();
        mReferenceteachers = FirebaseDatabase.getInstance().getReference("Teacher_portal")
                .orderByChild("School_Verify_Key").equalTo(school_main_grid.value);

    }
    public void readteachers(final DataStatus dataStatus){
        mReferenceteachers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                teachs.clear();
                List<String> keys =new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    teachers teach= keyNode.getValue(teachers.class);
                    teachs.add(teach);
                }
                dataStatus.DataIsLoaded(teachs,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
