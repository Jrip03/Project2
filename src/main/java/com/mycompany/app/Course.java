package com.mycompany.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Course {
    private String courseName;
    private final String courseID;
    private int classSize;
    private ArrayList<Student> roster;
    private final Teacher teacher;
    private GradeBook gradeBook;

    /**
     * 
     * @param name        course name
     * @param id          course id
     * @param studentList initial list of students for the class
     * @param teacher     teacher who teaches course
     */
    public Course(String name, String id, ArrayList<Student> studentList, Teacher teacher) {
        courseName = name;
        courseID = id;
        roster = studentList;
        classSize = roster.size();
        this.teacher = teacher;
        gradeBook = new GradeBook();
    }

    /**
     * 
     * @return returns name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @return returns ID of course
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * 
     * @return size of the class
     */
    public int getClassSize() {
        return classSize;
    }

    public ArrayList<Student> getStudentList() {
        return roster;
    }

    /**
     * 
     * @param ID id of a student object
     * @return object of a student in the course
     */
    public Student getStudent(String ID) {
        for (int i = 0; i < classSize; i++) {
            if (roster.get(i).getStudentID() == ID) {
                return roster.get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @return object of teacher for the course
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * attempts to add a student to the course and the gradebook
     * does not add student if it fails to add the student to gradebook first
     * 
     * @param student object of a student
     * 
     */
    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Could not remove student: Invalid ID");
        } else if (gradeBook.addStudent(student.getStudentID())) {
            roster.add(student);
            classSize++;
        }
    }

    /**
     * attempts to remove a student from course and the gradebook
     * does not remove student if it fails to remove student from gradebook
     * 
     * @param student object of a student
     * 
     */
    public void removeStudent(Student student) {
        if (student == null) {
            System.out.println("Could not remove student: Invalid ID");
        } else if (gradeBook.removeStudent(student.getStudentID())) {
            roster.remove(student);
            classSize--;
        }
    }

    /**
     * grades an assignment for the entire class
     * works through roster asking to input grade for each student
     * CWE-431
     * CWE-241
     */
    public void gradeAssignment(Scanner input) {
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
    }

    /**
     * 
     * @param student object of student
     * @param grade   assignment grade to be added to gradebook
     *                adds a grade for a single student
     *                does nothing if grade cannot be added
     */
    public void addSingleGrade(Student student, int grade) {
        Integer newGrade = grade;
        if (!gradeBook.addGrade(student.getStudentID(), newGrade)) {
            System.out.println("Grade could not be added\n");
        }
    }

    /**
     * edits the grade for a student in the course
     * 
     * @param student    object of student
     * @param gradeIndex index of grade in gradebook
     * @param grade      new grade to be changed to
     */
    public void editGrade(Student student, int gradeIndex, int grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade: value should be between 0 and 100\n");
        } else {
            Integer newGrade = grade;
            gradeBook.updateGrade(student.getStudentID(), gradeIndex, newGrade);
        }
    }

    /**
     * pulls the list of grades a student has in the gradebook
     * 
     * @param student object of student
     * @return Integer list of grades
     */
    public ArrayList<Integer> getGrades(Student student) {
        return gradeBook.getGrades(student.getStudentID());
    }

    /**
     * toSting for printing out a courses information
     */
    @Override
    public String toString() {
        String str = classSize + "\n";
        str = str + gradeBook.getNumAssignments();
        str = str + "\n" + courseID + ": " + courseName;
        str = str + "\nTeacher: " + teacher.getFirstName() + " " + teacher.getLastName();
        for (int i = 0; i < classSize; i++) {
            Student curStudent = roster.get(i);
            str = str + "\n" + curStudent.getStudentID() + " " + curStudent.getFirstName() + " "
                    + curStudent.getLastName() + ": ";
            str = str + getGrades(curStudent);
        }
        return str;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }
}
