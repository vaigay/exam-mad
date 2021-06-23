package com.example.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button student, classRom, student_class, report1, report2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = findViewById(R.id.student);
        classRom = findViewById(R.id.classRom);
        student_class = findViewById(R.id.student_class);
        report1 = findViewById(R.id.report1);
        report2 = findViewById(R.id.report2);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddStudentActivity.class);
                startActivity(intent);
            }
        });

        classRom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ClassRoomActivity.class);
                startActivity(intent);
            }
        });

        student_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddStudentToClassActivity.class);
                startActivity(intent);
            }
        });

        report1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Report1Activity.class);
                startActivity(intent);
            }
        });

        report2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Report2Activity.class);
                startActivity(intent);
            }
        });
    }
}