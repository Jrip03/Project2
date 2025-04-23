package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList; 

public class GradeBook {
    private HashMap<String, HashMap<String, List<Integer>>> grades;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        grades = new HashMap<>();
    }

    /*This method would add new grades for the student
      The seeIfPresent method would check if the student or the subject already existed.
      It would create a student or subject if they don't exist.
      
    */
    public void addGrade(String studentName,String subject, int grade) {
        grades.seeIfPresent(studentName, new HashMap<>());
        HashMap<String, List<Integer>> studentGrades = grades.get(studentName);
        studentGrades.seeIfPresent(subject, new ArrayList<>());
        studentGrades.get(subject).add(grade);
    }

    /*
     * 
     */
    public void updateGrade(String studentName, String subject, int index, int newGrade) {
        if (grades.containsKey(studentName)) {
            HashMap<String, List<Integer>> studentGrades = grades.get(studentName);
            if (studentGrades.containsKey(subject)) {
                List<Integer> gradeList = studentGrades.get(subject);
                if (index >= 0 && index < gradeList.size()) {
                    gradeList.set(index, newGrade);
                } else {
                    System.out.println("Invalid grade index");
                }
            } else {
                System.out.println("Subject not found for " + studentName + ".");
            }
        } else {
            System.out.println("Student not found");
        }
    }

    /*This method would help in printing the grade.
     * 
     */
    public void printGrade(String name) {
        if (grades.isEmpty()) {
            System.out.println("No grades added");
        } else if (!grades.containsKey(name)) {
            System.out.println("Student not found");
        } else {
            System.out.println("Grades for student: " + name);
            HashMap<String, List<Integer>> studentGrades = grades.get(name);
            for (String subject : studentGrades.keySet()) {
                System.out.println("Subject: " + subject);
                List<Integer> gradeList = studentGrades.get(subject);
                if (gradeList.isEmpty()) {
                    System.out.println("  No grades yet");
                } else {
                    for (int i = 0; i < gradeList.size(); i++) {
                        System.out.println("  Grade " + (i + 1) + ": " + gradeList.get(i));
                    }
                }
            }
        }
    }
}