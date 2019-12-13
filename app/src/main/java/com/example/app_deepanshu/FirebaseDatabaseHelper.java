package com.example.app_deepanshu;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceSubjects;
    private List<teacher> subjects =new ArrayList<>();

    public interface DataStatus{
        void DataisLoaded(List<teacher> subjects,List<String>keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase =FirebaseDatabase.getInstance();
        mReferenceSubjects = mDatabase.getReference("Teacher_portal").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Teacher_Subjects");
    }
    public void readSubjects(final DataStatus dataStatus)
    {
        mReferenceSubjects.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                subjects.clear();
                List<String> keys =new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    teacher subject= keyNode.getValue(teacher.class);
                    subjects.add(subject);
                }
                dataStatus.DataisLoaded(subjects,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void updateSubject(String key, teacher subject, final DataStatus dataStatus){
        mReferenceSubjects.child(key).setValue(subject).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });

    }
    public void deletesubjects(String key, final DataStatus dataStatus){
    mReferenceSubjects.child(key).setValue(null)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    dataStatus.DataIsDeleted();
                }
            });
    }
}
