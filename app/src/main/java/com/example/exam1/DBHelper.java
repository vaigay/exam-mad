package com.example.exam1;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), birth_year INTERGER, home_town VARCHAR(200), grade VARCHAR(50))");
        db.execSQL("CREATE TABLE IF NOT EXISTS class_room(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), description VARCHAR(200))");
        db.execSQL("CREATE TABLE IF NOT EXISTS student_class(id INTEGER PRIMARY KEY AUTOINCREMENT, student_id INTEGER, class_id INTEGER, semester VARCHAR(50), credit INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        db.execSQL("DROP TABLE IF EXISTS class_room");
        db.execSQL("DROP TABLE IF EXISTS student_class");
        onCreate(db);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public int insertStudent(Student student){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.putNull("id");
        cv.put("name",student.getName());
        cv.put("grade",student.getGrade());
        cv.put("birth_year",student.getBirthYear());
        cv.put("home_town",student.getHomeTown());
        return (int) db.insert("student",null,cv);
    }

    public ArrayList<Student> getAllStudent(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM student";
        Cursor c = db.rawQuery(sql,null);
        ArrayList<Student> students = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int birthYear = c.getInt(c.getColumnIndex("birth_year"));
            String homeTown = c.getString(c.getColumnIndex("home_town"));
            String grade = c.getString(c.getColumnIndex("grade"));
            Student tmp = new Student(id,name,birthYear,homeTown,grade);
            students.add(tmp);
        }
        return students;
    }

    public int insertClass(ClassRoom room){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.putNull("id");
        cv.put("name",room.getName());
        cv.put("description",room.getDescription());
        return (int) db.insert("class_room",null,cv);
    }

    public ArrayList<ClassRoom> getAllClass(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM class_room";
        Cursor c = db.rawQuery(sql,null);
        ArrayList<ClassRoom> classRooms = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            String description = c.getString(c.getColumnIndex("description"));
            ClassRoom tmp = new ClassRoom(id,name,description);
            classRooms.add(tmp);
        }
        return classRooms;
    }

    public void insertStudentToClass(int idStudent, int idClass){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.putNull("id");
        cv.put("student_id",idStudent);
        cv.put("class_id",idClass);
        cv.put("semester","Kỳ 1");
        cv.put("credit",3);
        db.insert("student_class",null,cv);
    }

    public ArrayList<StudentInClass>  getAllStudentInClass(){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT student.name as stuName, class_room.name as className, student.id as stuId, class_room.id as classId " +
                "FROM student, class_room, student_class " +
                "WHERE stuId = student_class.student_id AND classId = student_class.class_id";
        ArrayList<StudentInClass> studentInClasses = new ArrayList<>();
        Cursor c = db.rawQuery(sql,null);
        while(c.moveToNext()){
            int studentId = c.getInt(c.getColumnIndex("stuId"));
            String studentName = c.getString(c.getColumnIndex("stuName"));
            int classId = c.getInt(c.getColumnIndex("classId"));
            String className = c.getString(c.getColumnIndex("className"));
            StudentInClass tmp = new StudentInClass(studentId,studentName,classId,className);
            studentInClasses.add(tmp);
        }
        c.close();
        return studentInClasses;
    }

    public boolean checkStudentInClass(int idStudent, int idClass){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT 1 FROM student_class WHERE student_id = " + idStudent + " AND class_id = " + idClass;
        Cursor c = db.rawQuery(sql,null);
        if(c.moveToNext())
            return true;
        return false;
    }

    public ArrayList<Student> getAllReport1Student(String namex, String gradex){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM student WHERE name = '" + namex + "' AND grade = '" + gradex+"'";
        Cursor c = db.rawQuery(sql,null);
        ArrayList<Student> students = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int birthYear = c.getInt(c.getColumnIndex("birth_year"));
            String homeTown = c.getString(c.getColumnIndex("home_town"));
            String grade = c.getString(c.getColumnIndex("grade"));
            Student tmp = new Student(id,name,birthYear,homeTown,grade);
            students.add(tmp);
        }
        c.close();
        return students;
    }

    public ArrayList<ClassReport> getClassReport(){
        SQLiteDatabase db =getReadableDatabase();
        String sql = "SELECT COUNT(student_class.class_id) as number, class_room.id as id, class_room.name as name, class_room.description as des " +
                "FROM class_room, student_class " +
                "WHERE class_room.id = student_class.class_id " +
                "GROUP BY student_class.class_id ORDER BY number DESC";
        Cursor c = db.rawQuery(sql,null);
        ArrayList<ClassReport> classReports = new ArrayList<>();
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            String description = c.getString(c.getColumnIndex("des"));
            ClassRoom tmp = new ClassRoom(id,name,description);
            int number = c.getInt(c.getColumnIndex("number"));
            ClassReport report = new ClassReport();
            report.setClassRoom(tmp);
            report.setNumber(number);
            classReports.add(report);
        }
        c.close();
        return classReports;
    }

}
