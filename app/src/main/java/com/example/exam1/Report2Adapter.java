package com.example.exam1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Report2Adapter extends RecyclerView.Adapter<Report2Adapter.ViewHolder>{

    ArrayList<ClassReport> classReports;

    public Report2Adapter(ArrayList<ClassReport> classReports) {
        this.classReports = classReports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_report_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Report2Adapter.ViewHolder holder, int position) {
        ClassReport report = classReports.get(position);
        holder.id.setText(String.valueOf(report.getClassRoom().getId()));
        holder.name.setText(report.getClassRoom().getName());
        holder.des.setText(report.getClassRoom().getDescription());
        holder.number.setText(String.valueOf(report.getNumber()));
    }

    @Override
    public int getItemCount() {
        return classReports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, des, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.data5_1);
            name = itemView.findViewById(R.id.data5_2);
            des = itemView.findViewById(R.id.data5_3);
            number = itemView.findViewById(R.id.data5_4);
        }
    }
}
