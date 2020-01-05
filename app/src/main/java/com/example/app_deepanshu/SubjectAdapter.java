package com.example.app_deepanshu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private Context mCtx;
    private List<Subject> subjectList;

    public SubjectAdapter(Context mCtx, List<Subject> subjectList) {
        this.mCtx = mCtx;
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        final Subject subject = subjectList.get(position);

        holder.textView.setText(subject.getTitle());
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mCtx, subject.getTitle(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mCtx, module_list.class);
//                Bundle b = new Bundle();
//                b.putInt("id", subject.getId());
//                intent.putExtras(b);
//                mCtx.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    class SubjectViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RelativeLayout relativeLayout;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.name);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }
    }
}
