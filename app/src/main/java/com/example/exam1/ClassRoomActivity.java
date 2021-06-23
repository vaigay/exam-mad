package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassRoomActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private DBHelper dbHelper;
    private TextView name, des;
    private ArrayList<ClassRoom> classRooms;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_room);
        dbHelper = new DBHelper(this,DBInfo.dbName,null,DBInfo.version);
        setupData();
        setupId();
    }

    private void setupId() {
        name = findViewById(R.id.class_name);
        des = findViewById(R.id.class_des);
        add = findViewById(R.id.add_class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String d = des.getText().toString();
                if( n.isEmpty() || d.isEmpty() ){
                    Toast.makeText(ClassRoomActivity.this,"No",Toast.LENGTH_SHORT).show();
                    return;
                }
                ClassRoom room = new ClassRoom();
                room.setName(n);
                room.setDescription(d);
                int id = dbHelper.insertClass(room);
                room.setId(id);
                classRooms.add(room);
                Toast.makeText(ClassRoomActivity.this,room.toString(),Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                name.setText("");
                des.setText("");
            }
        });

    }

    private void setupData() {
        classRooms = dbHelper.getAllClass();
        Log.d("classaassa", "size = " + classRooms.size());
        RecyclerView recyclerView = findViewById(R.id.list_class);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ClassRoomAdapter(classRooms);
        recyclerView.setAdapter(adapter);
    }
}