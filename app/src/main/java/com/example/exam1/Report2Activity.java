package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Report2Activity extends AppCompatActivity {
    private ArrayList<ClassReport> classReports;
    private DBHelper dbHelper;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);
        dbHelper = new DBHelper(this,DBInfo.dbName,null,DBInfo.version);
        setupData();
    }

    private void setupData() {
        classReports = dbHelper.getClassReport();
        RecyclerView recyclerView = findViewById(R.id.class_report);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Report2Adapter(classReports);
        recyclerView.setAdapter(adapter);
    }
}