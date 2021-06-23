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

public class AddStudentToClassActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private Spinner studentSpinner,classSpinner;
    private Button add;
    private ArrayList<Student> students;
    private ArrayList<ClassRoom> classRooms;
    private RecyclerView.Adapter adapter;
    private ArrayList<StudentInClass> studentInClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_to_class);
        dbHelper = new DBHelper(this,DBInfo.dbName,null,DBInfo.version);
        setupData();
        setupId();
    }

    private void setupId() {
        students = dbHelper.getAllStudent();
        classRooms = dbHelper.getAllClass();
        spin1();
        spin2();

        add = findViewById(R.id.add_student_to_class_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idStudent = students.get(studentSpinner.getSelectedItemPosition()).getId();
                int idClass = classRooms.get(classSpinner.getSelectedItemPosition()).getId();
                if(dbHelper.checkStudentInClass(idStudent,idClass)){
                    Toast.makeText(AddStudentToClassActivity.this,"Sinh viên đã ở trong lớp này rồi",Toast.LENGTH_SHORT).show();
                }
                else{
                    dbHelper.insertStudentToClass(idStudent,idClass);
                    Toast.makeText(AddStudentToClassActivity.this,"Thêm sinh viên thành công",Toast.LENGTH_SHORT).show();
                    StudentInClass tmp = new StudentInClass(idStudent,students.get(studentSpinner.getSelectedItemPosition()).getName(),idClass,classRooms.get(classSpinner.getSelectedItemPosition()).getName());
                    studentInClasses.add(tmp);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void spin2() {
        classSpinner = findViewById(R.id.list_class_2);
        ArrayList<String> classData = new ArrayList<>();
        for(ClassRoom tmp : classRooms){
            String x = tmp.getId() + "-" + tmp.getName();
            classData.add(x);
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,classData);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        classSpinner.setAdapter(adapter2);
    }

    private void spin1() {

        studentSpinner  = findViewById(R.id.list_student_2);
        ArrayList<String> studentData = new ArrayList<>();
        for(Student tmp : students){
            String x = tmp.getId() + "-" + tmp.getName();
            studentData.add(x);
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,studentData);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        studentSpinner.setAdapter(adapter1);
    }

    private void setupData() {
        studentInClasses = dbHelper.getAllStudentInClass();

        RecyclerView recyclerView = findViewById(R.id.list_student_in_class);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudentInClassAdapter(studentInClasses);
        recyclerView.setAdapter(adapter);
    }
}