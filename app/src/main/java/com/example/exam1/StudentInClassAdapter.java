package com.example.exam1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentInClassAdapter extends RecyclerView.Adapter<StudentInClassAdapter.ViewHolder>{
    ArrayList<StudentInClass> studentInClasses;

    public StudentInClassAdapter(ArrayList<StudentInClass> studentInClasses) {
        this.studentInClasses = studentInClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_in_class_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentInClass tmp = studentInClasses.get(position);
        holder.student_id.setText(String.valueOf(tmp.getIdStudent()));
        holder.student_name.setText(tmp.getStudentName());
        holder.class_id.setText(String.valueOf(tmp.getIdClass()));
        holder.class_name.setText(tmp.getClassName());
    }

    @Override
    public int getItemCount() {
        return studentInClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView student_id,student_name, class_id, class_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id = itemView.findViewById(R.id.data3_1);
            student_name = itemView.findViewById(R.id.data3_2);
            class_id = itemView.findViewById(R.id.data3_3);
            class_name = itemView.findViewById(R.id.data3_4);
        }
    }
}
