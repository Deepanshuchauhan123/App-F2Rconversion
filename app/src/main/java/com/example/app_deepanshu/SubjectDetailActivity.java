package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SubjectDetailActivity extends AppCompatActivity {
    private TextView mclass_editext;
    private TextView mbatch_edittext;
    private TextView mstream_editext;
    private TextView msubject_editext;

    private Button mdelete_btn;
    private Button mback_btn;

    private String key;
    private String Class;
    private String batch;
    private String subject;
    private String stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        key=getIntent().getStringExtra("key");
        Class=getIntent().getStringExtra("classes");
        batch=getIntent().getStringExtra("batch");
        subject=getIntent().getStringExtra("subject");
        stream=getIntent().getStringExtra("stream");

        mclass_editext =(TextView) findViewById(R.id.edittext_class);
        mclass_editext.setText(Class);
        mbatch_edittext=(TextView) findViewById(R.id.edittext_batch);
        mbatch_edittext.setText(batch);
        mstream_editext=(TextView) findViewById(R.id.edittext_stream);
        mstream_editext.setText(stream);
        msubject_editext=(TextView) findViewById(R.id.edittext_subject);
        msubject_editext.setText(subject);

        mdelete_btn= (Button) findViewById(R.id.delete);
        mback_btn= (Button) findViewById(R.id.back);

        mdelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deletesubjects(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataisLoaded(List<teacher> subjects, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(SubjectDetailActivity.this,"Subjects record has been" +
                                "deleted sucessfully !", Toast.LENGTH_LONG).show();
                        finish();return;

                    }
                });
            }
        });
        mback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();return;
            }
        });
    }
}
