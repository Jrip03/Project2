package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Course{
    private final String courseName;
    private final String courseID;
    private int classSize;
    private ArrayList<Student> roster;
    private final Teacher teacher;
    private GradeBook gradeBook;

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
        classSize++;
    }

    public void removeStudent(String studentID){
        
        classSize--;
    }

    //add assignment
    public void gradeAssignment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the grade for the following students: ");
        for (int i = 0; i < classSize; i++){
            System.out.print(roster.get(i).getFirstName() + " " + roster.get(i).getLastName() + ": ");
            int grade = input.nextInt();
            //add grade to gradebook

            System.out.println();
        }
        input.close();
    }

    //add to gradebook for a specific student
    public void addGrade(Student student, int grade){
        //find student in gradebook and add grade
    }

    @Override
    public String toString(){
        String str = courseID + ": " +  courseName;
        str = str + "\nTeacher: " + teacher.getFirstName() + " " + teacher.getLastName();
        for(int i = 0; i< classSize; i++){
            str = str + "\n" + roster.get(i).getFirstName() + " " + roster.get(i).getLastName() + ": ";
            //str = str + gradeBook;
        } 
        return str;
    }
}