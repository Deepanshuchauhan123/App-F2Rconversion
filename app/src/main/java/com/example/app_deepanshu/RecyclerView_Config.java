package com.example.app_deepanshu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerView_Config {
    private Context mcontext;
    private SubjectAdapter msubjectAdapter;
    public void setConfig(RecyclerView recyclerView, Context context,List<teacher> subjects, List<String> keys){
    mcontext = context;
    msubjectAdapter =new SubjectAdapter(subjects,keys);
    recyclerView.setLayoutManager(new LinearLayoutManager(context));
    recyclerView.setAdapter(msubjectAdapter);
    }

    class SubjectItemView extends RecyclerView.ViewHolder{
        private TextView mClass;
        private TextView mbatch;
        private TextView msubject;
        private TextView mstream;

        private String key;

        public SubjectItemView(ViewGroup parent)
        {
            super(LayoutInflater.from(mcontext).inflate(R.layout.subject_list_items, parent,false));
            mClass =(TextView) itemView.findViewById(R.id.Class);
            mbatch=(TextView) itemView.findViewById(R.id.batch);
            msubject =(TextView) itemView.findViewById(R.id.subject);
            mstream=(TextView) itemView.findViewById(R.id.stream);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent intent = new Intent(mcontext,SubjectDetailActivity.class );
                  intent.putExtra("key",key);
                    intent.putExtra("classes", mClass.getText().toString());
                    intent.putExtra("batch", mbatch.getText().toString());
                    intent.putExtra("subject", msubject.getText().toString());
                    intent.putExtra("stream", mstream.getText().toString());

                    mcontext.startActivity(intent);
                }
            });

        }
        public void bind(teacher subject, String key ){
            mClass.setText(subject.getClasses());
            mbatch.setText(subject.getBatch());
            msubject.setText(subject.getSubject());
            mstream.setText(subject.getStream());
            this.key=key;
        }
    }
    class SubjectAdapter extends RecyclerView.Adapter<SubjectItemView>{
        private List<teacher>msubjectList;
        private List<String>mkeys;

        public SubjectAdapter(List<teacher> msubjectList, List<String> mkeys) {
            this.msubjectList = msubjectList;
            this.mkeys = mkeys;
        }
        @NonNull
        @Override
        public SubjectItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SubjectItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SubjectItemView holder, int position) {
        holder.bind(msubjectList.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return msubjectList.size();
        }
    }
}
