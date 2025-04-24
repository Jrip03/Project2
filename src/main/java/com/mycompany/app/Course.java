package com.mycompany.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        gradeBook = new GradeBook();
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
        if (gradeBook.addStudent(student.getStudentID())) {
            roster.add(student);
            classSize++;
        }
    }

    public void removeStudent(Student student) {
        if (gradeBook.removeStudent(student.getStudentID())) {
            roster.remove(student);
            classSize--;
        }
    }

    public void gradeAssignment(){
        Scanner input = new Scanner(System.in);
        int index = 0;
        System.out.println("Enter the grade for the following students: ");
        while (index < classSize) {
            System.out.print(roster.get(index).getFirstName() + " " + roster.get(index).getLastName() + ": ");
            try {
                int inputGrade = input.nextInt();
                if (inputGrade < 0 || inputGrade > 100) {
                    System.out.println("Not a valid input: grade value should be from 0-100\n");
                } else {
                    Integer grade = inputGrade;
                    if (gradeBook.addGrade(roster.get(index).getStudentID(), grade)) {
                        index++;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid input: grade value should be from 0-100\n");
            }
        }
        System.out.println();
        input.close();
    }

    public void addSingleGrade(Student student, int grade) {
        Integer newGrade = grade;
        if (!gradeBook.addGrade(student.getStudentID(), newGrade)) {
            System.out.println("Grade could not be added\n");
        }
    }

    public ArrayList<Integer> getGrades(Student student) {
        return gradeBook.getGrades(student.getStudentID());
    }

    @Override
    public String toString(){
        String str = courseID + ": " +  courseName;
        str = str + "\nTeacher: " + teacher.getFirstName() + " " + teacher.getLastName();
        for(int i = 0; i< classSize; i++){
            str = str + "\n" + roster.get(i).getFirstName() + " " + roster.get(i).getLastName() + ": ";
            str = str + getGrades(roster.get(i));
        } 
        return str;
    }
}