package com.example.exam1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<Student> students;

    public StudentAdapter(ArrayList<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.code.setText(String.valueOf(student.getId()));
        holder.name.setText(student.getName());
        holder.birthYear.setText(String.valueOf(student.getBirthYear()));
        holder.homeTown.setText(student.getHomeTown());
        holder.grade.setText(student.getGrade());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView code,name, birthYear, homeTown, grade;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.data1);
            name = itemView.findViewById(R.id.data2);
            birthYear = itemView.findViewById(R.id.data3);
            homeTown = itemView.findViewById(R.id.data4);
            grade = itemView.findViewById(R.id.data5);
        }
    }



}
