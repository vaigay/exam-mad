package com.example.exam1;

public class StudentInClass {
    private int idStudent;
    private String studentName;
    private int idClass;
    private String className;

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public StudentInClass() {
    }

    public StudentInClass(int idStudent, String studentName, int idClass, String className) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.idClass = idClass;
        this.className = className;
    }
}
