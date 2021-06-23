package com.example.exam1;

public class Student {
    private int id;
    private String name;
    private int birthYear;
    private String homeTown;
    private String grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", homeTown='" + homeTown + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Student(String name, int birthYear, String homeTown, String grade) {
        this.name = name;
        this.birthYear = birthYear;
        this.homeTown = homeTown;
        this.grade = grade;
    }

    public Student() {
    }

    public Student(int id, String name, int birthYear, String homeTown, String grade) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.homeTown = homeTown;
        this.grade = grade;
    }
}
