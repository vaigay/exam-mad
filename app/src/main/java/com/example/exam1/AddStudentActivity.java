package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText name, birthYear, homeTown;
    private Spinner grade;
    private Button add;
    private ArrayList<Student> students;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        dbHelper = new DBHelper(this,DBInfo.dbName,null,DBInfo.version);
        setupId();
        setupData();
    }

    private void setupData() {
        students = dbHelper.getAllStudent();

        RecyclerView recyclerView = findViewById(R.id.list_student);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);
    }

    private void setupId() {
        name = findViewById(R.id.student_name);
        birthYear = findViewById(R.id.student_birth_year);
        homeTown = findViewById(R.id.student_home_town);
        grade = findViewById(R.id.student_grade);
        add = findViewById(R.id.add_student);
        List<String> grades = new ArrayList<>();
        grades.add("Năm 1");
        grades.add("Năm 2");
        grades.add("Năm 3");
        grades.add("Năm 4");
        grades.add("Năm 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,grades);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        grade.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddStudentActivity.this,"123123",Toast.LENGTH_SHORT);
                if(birthYear.getText().toString().isEmpty() || name.getText().toString().isEmpty() || homeTown.getText().toString().isEmpty() ){
                    return;
                }
                int birthY = Integer.parseInt(birthYear.getText().toString().trim());
                if(birthY >= 2020 || birthY <= 0){
                    Toast.makeText(AddStudentActivity.this,"Năm sinh vô lý",Toast.LENGTH_SHORT).show();
                    return;
                }
                String n = name.getText().toString().trim();
                String ht = homeTown.getText().toString().trim();
                String g = grade.getSelectedItem().toString();

                Student student = new Student(n,birthY,ht,g);

                Toast.makeText(AddStudentActivity.this,student.toString(),Toast.LENGTH_SHORT).show();
                name.setText("");
                homeTown.setText("");
                birthYear.setText("");
                int id = dbHelper.insertStudent(student);
                student.setId(id);
                students.add(student);
                adapter.notifyDataSetChanged();

            }
        });


    }
}