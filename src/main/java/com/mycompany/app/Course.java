package com.mycompany.app;

import java.util.ArrayList;

public class Course{
    private final String courseName;
    private final String courseID;
    private int classSize;
    private ArrayList<Student> roster;
    private final Teacher teacher;

    public Course(String name, String id, ArrayList<Student> studentList, Teacher teacher){
        courseName = name;
        courseID = id;
        roster = studentList;
        classSize = roster.size();
        this.teacher = teacher;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseID(){
        return courseID;
    }

    public int getClassSize(){
        return classSize;
    }

    public ArrayList<Student> getStudentList(){
        return roster;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void addStudent(Student student){
        roster.add(student);
    }

    public void removeStudent(String studentName){
        
    }
}