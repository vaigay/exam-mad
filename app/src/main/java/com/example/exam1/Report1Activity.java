package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Report1Activity extends AppCompatActivity {
    private ArrayList<Student> students;
    private DBHelper dbHelper;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
        dbHelper = new DBHelper(this,DBInfo.dbName,null,DBInfo.version);
        setupData();
    }

    private void setupData() {
        students = dbHelper.getAllReport1Student("Nam","Năm 2");

        RecyclerView recyclerView = findViewById(R.id.list_student_report1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);
    }
}