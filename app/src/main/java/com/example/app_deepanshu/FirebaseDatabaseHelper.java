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

public class FirebaseDatabaseHelper extends Add_Student{
    private FirebaseDatabase mDatabase, sDatabase;
    private DatabaseReference mReferenceSubjects, mReferenceStudent,mRef;
    public String value;
    public String sub_Class;
    private List<teacher> subjects =new ArrayList<>();
    public interface DataStatus{
        void DataisLoaded(List<teacher> subjects,List<String>keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        sub_Class =Add_Student.citem;

        mRef = FirebaseDatabase.getInstance()
                .getReference("Teacher_portal").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        mRef.child("School_Verify_Key").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                value = snapshot.getValue().toString();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        sDatabase =FirebaseDatabase.getInstance();
        mReferenceStudent = sDatabase.getReference("School_Students").child(value);


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

    public void addStudent(Student_model stu,final DataStatus dataStatus)
    {
        String key=mReferenceStudent.child(sub_Class).push().getKey();
        mReferenceStudent.child(key).setValue(stu)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    dataStatus.DataIsInserted();
                    }
                });
    }
}
