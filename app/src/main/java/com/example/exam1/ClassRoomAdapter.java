package com.example.exam1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassRoomAdapter extends RecyclerView.Adapter<ClassRoomAdapter.ViewHolder>{
    private ArrayList<ClassRoom> classRooms;

    public ClassRoomAdapter(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_row,parent,false);
        return new ClassRoomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassRoom room = classRooms.get(position);
        holder.data1.setText(String.valueOf(room.getId()));
        holder.data2.setText(room.getName());
        holder.data3.setText(room.getDescription());
    }

    @Override
    public int getItemCount() {
        return classRooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView data1, data2, data3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data1 = itemView.findViewById(R.id.data_2_1);
            data2 = itemView.findViewById(R.id.data_2_2);
            data3 = itemView.findViewById(R.id.data_2_3);
        }
    }
}