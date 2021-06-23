package com.example.exam1;

public class ClassReport {
    private ClassRoom classRoom;
    private int number;

    public ClassReport(ClassRoom classRoom, int number) {
        this.classRoom = classRoom;
        this.number = number;
    }

    public ClassReport() {
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
