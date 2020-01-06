package com.example.app_deepanshu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class teacher_reg extends AppCompatActivity implements View.OnClickListener {

    ProgressBar simpleProgressBar;
    EditText email1,password,sch_name,teacher_adhaar,teach_name,school_Key,teach_mobile,teach_area,teach_state,cnf_pass;
    Integer sch_id;
    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        email1 = findViewById(R.id.teacher_email);
        password=findViewById(R.id.teacher_password);
        teacher_adhaar=findViewById(R.id.teacher_adhaar);
        teach_name=findViewById(R.id.teacher_name);
        school_Key=findViewById(R.id.school_key);
        sch_name=findViewById(R.id.school_name);
        teach_mobile=findViewById(R.id.teacher_mobile);
        cnf_pass=findViewById(R.id.cnf_password);
        teach_area=findViewById(R.id.teacher_village);
        teach_state=findViewById(R.id.teacher_state);
        findViewById(R.id.after_verify).setVisibility(View.GONE);
        findViewById(R.id.hai_jo_hai).setVisibility(View.VISIBLE);

      //  mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button_submit).setOnClickListener(this);
        findViewById(R.id.btn_verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key_teach=school_Key.getText().toString().trim();
                //code for btn Verify key
                if (key_teach.isEmpty()) {
                    school_Key.setError("school  id is required");
                    school_Key.requestFocus();
                    return;
                }
                Call<Key_Verify> call= RetrofitClient.getInstance().getApi().verifyTeacher(key_teach);
                call.enqueue(new Callback<Key_Verify>() {
                    @Override
                    public void onResponse(Call<Key_Verify> call, Response<Key_Verify> response) {
                        if(response.code()==200){
                            Toast.makeText(teacher_reg.this,"Verified Sucessfully",Toast.LENGTH_LONG).show();
                            sch_id=response.body().getSchool_id();
                            sch_name.setText(response.body().getFirst_name());
                            findViewById(R.id.after_verify).setVisibility(View.VISIBLE);
                            findViewById(R.id.hai_jo_hai).setVisibility(View.GONE);


                        }else{
                            Toast.makeText(teacher_reg.this,"Not a Valid Key ",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Key_Verify> call, Throwable t) {

                        Toast.makeText(teacher_reg.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

            private void teacher_signup(){

        String email= email1.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String adhaar = teacher_adhaar.getText().toString().trim();
        String schl_key = school_Key.getText().toString().trim();
        String name1= teach_name.getText().toString().trim();
        String cnf_pas=cnf_pass.getText().toString().trim();
        String mob1 = teach_mobile.getText().toString().trim();
        String area1= teach_area.getText().toString().trim();
        String state1= teach_state.getText().toString().trim();

                if (adhaar.isEmpty()) {
                    teacher_adhaar.setError("Adhaar Number is required");
                    teacher_adhaar.requestFocus();
                    return;
                }
                if (!(adhaar.length()==16)) {
                    teacher_adhaar.setError("Enter a Valid Adhaar Number");
                    teacher_adhaar.requestFocus();
                    return;
                }
        //Email
        if (!Patterns.EMAIL_ADDRESS .matcher(email).matches()) {
            email1.setError("Email is Wrong");
            email1.requestFocus();
            return;
        }
                //for name
                if (name1.isEmpty()) {
                    teach_name.setError("Teacher Name is Required");
                    teach_name.requestFocus();
                    return;
                }
        //for Password
        if (pass1.length() < 6) {
            password.setError("Minimum length of Password is 6");
            password.requestFocus();
            return;
        }

        if(!cnf_pas.equals(pass1))
        {
            cnf_pass.setError("Password and Confirm Password Should Match");
            cnf_pass.requestFocus();
            return;
        }

        //for phone
        if (mob1.isEmpty()) {
            teach_mobile.setError("Phone is Required");
            teach_mobile.requestFocus();
            return;
        }

        if (mob1.length()!= 10) {
            teach_mobile.setError("Enter a Valid mobile Number");
            teach_mobile.requestFocus();
            return;
        }
        //for area
        if (area1.isEmpty()) {
            teach_area.setError("Teacher Area is Required");
            teach_area.requestFocus();
            return;
        }

        if (state1.isEmpty()) {
            teach_state.setError("State is required");
            teach_state.requestFocus();
            return;
        }

                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .createTeacher(adhaar,pass1,email,
                                name1,mob1,area1,
                                state1,sch_id);
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if(response.code()==201){
                            DefaultResponse dr=response.body();
                            Toast.makeText(teacher_reg.this,"User Created Successfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(teacher_reg.this, first_cat.class));
                        }else {
                            Toast.makeText(teacher_reg.this,"User Already Exist",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(teacher_reg.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        //VERIFICATION OF TEACHER KEY FROM SCHOOL GENERATED KEY

//        Query keyQuery=FirebaseDatabase.getInstance().getReference()
//                .child("School_portal").orderByChild("School_Verify_Key").equalTo(sub1);
//        keyQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.getChildrenCount()>0){
//                    flag=1;
//                }
//                else {
//                    teacher_sub.setError("Not a valid school key");
//                    teacher_sub.requestFocus();
//                    return;
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        if(flag==1) {
//
//            mAuth.createUserWithEmailAndPassword(email, pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (task.isSuccessful()) {
//                        teacher teach = new teacher(
//                                email1.getText().toString(),
//                                sch_name.getText().toString(),
//                                teach_name.getText().toString(),
//                                teacher_sub.getText().toString(),
//                                teach_mobile.getText().toString(),
//                                teach_area.getText().toString(),
//                                teach_state.getText().toString()
//                        );
//                        FirebaseDatabase.getInstance().getReference("Teacher_portal")
//                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                .setValue(teach).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    simpleProgressBar.setVisibility(View.VISIBLE);
//                                    Toast.makeText(teacher_reg.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(teacher_reg.this, first_cat.class));
//                                } else {
//                                    //display a failure message
//                                    Toast.makeText(getApplicationContext(), "Already have an Account", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//
//                    } else {
//
//                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_submit:
                teacher_signup();
                break;
        }

    }
}















//<LinearLayout
//                android:layout_width="wrap_content"
//                        android:layout_height="wrap_content"
//                        android:orientation="vertical"
//                        android:padding="10dp"
//                        android:layout_gravity="center">
//<RelativeLayout
//                    android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:layout_gravity="center_horizontal"
//                            android:padding="0dp">
//<com.google.android.material.textfield.TextInputLayout
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:paddingRight="100dp"
//        android:paddingBottom="10dp"
//        android:gravity="center"
//        app:passwordToggleEnabled="true"
//        android:layout_marginTop="20dp">
//<EditText
//                            android:id="@+id/teacher_subject"
//                                    android:layout_width="250dp"
//                                    android:layout_height="55dp"
//                                    android:paddingLeft="10dp"
//                                    android:background="#ffffff"
//                                    android:drawableLeft="@drawable/ic_perm_identity_black_24dp"
//                                    android:layout_marginTop="20dp"
//                                    android:hint="विद्यालय पंजीकरण नम्बर  "/>
//</com.google.android.material.textfield.TextInputLayout>
//<Button
//                        android:layout_width="100dp"
//                                android:layout_height="55dp"
//                                android:text="VERIFY"
//                                android:id="@+id/btn_verify"
//                                android:background="#92B4C2"
//                                android:layout_marginTop="30dp"
//                                android:layout_marginLeft="255dp"
//                                android:gravity="center"
//                                android:textSize="18sp"
//                                />
//</RelativeLayout>
//</LinearLayout>
