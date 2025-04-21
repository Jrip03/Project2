package com.mycompany.app;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList; 

public class GradeBook {
    private HashMap<String, HashMap<String, List<Integer>>> grades;

    public GradeBook {
        grades = new HashMap<>();
    }

    public void addGrade(String studentName,String subject, int grade) {
        grades.putIfAbsent(studentName, new HashMap<>());
        HashMap<String, List<Integer>> studentGrades = grades.get(studentName);
        studentGrades.putIfAbsent(subject, new ArrayList<>());
        studentGrades.get(subject).add(grade);
    }

    public void updateGrade(String studentName, String subject, int index, int newGrade) {
        if (grades.containsKey(studentName)) {
            HashMap<String, List<Integer>> studentGrades = grades.get(studentName);
            if (studentGrades.containsKey(subject)) {
                List<Integer> gradeList = studentGrades.get(subject);
                if (index >= 0 && index < gradeList.size()) {
                    gradeList.set(index, newGrade);
                } else {
                    System.out.println("Invalid grade index.");
                }
            } else {
                System.out.println("Subject not found for " + studentName + ".");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public void printGrade(String name) {
        if (grades.isEmpty()) {
            System.out.println("No grades added.");
        } else if (!grades.containsKey(studentName)) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Grades for student: " + studentName);
            HashMap<String, List<Integer>> studentGrades = grades.get(studentName);
            for (String subject : studentGrades.keySet()) {
                System.out.println("Subject: " + subject);
                List<Integer> gradeList = studentGrades.get(subject);
                if (gradeList.isEmpty()) {
                    System.out.println("  No grades yet.");
                } else {
                    for (int i = 0; i < gradeList.size(); i++) {
                        System.out.println("  Grade " + (i + 1) + ": " + gradeList.get(i));
                    }
                }
            }
        }
    }
}
    