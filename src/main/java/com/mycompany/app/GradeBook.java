package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.ArrayList; 

public class GradeBook {
    private HashMap<String, List<Integer>> studentGrades;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        studentGrades = new HashMap<>();
    }

    // Add a new student with a grade
    public void addStudent(String ID) {
        if (!studentGrades.containsKey(ID)) {
            studentGrades.put(ID, new List<Integer>);
        } else {
            System.out.println("Student already exists");
        }
    }

    public void addGrade(String ID, Integer grade) {
        if (!studentGrades.containsKey(ID)) {
            System.out.println("Student is not fount");
        } else {
            studentGrades.computeIfPresent(ID, (Key,value) -> value.add(grade)); 
        }
    }

    // Get a student's grade
    public List<Integer> getGrades(String ID) {
        return studentGrades.get(ID);
    }

    // Update a student's grade
    public void updateGrade(String ID, Integer newGrade) {
        if (studentGrades.containsKey(ID)) {
            studentGrades.computeIfPresent(ID, (Key,value) -> value.add(grade));
        } else {
            System.out.println("Student not found");
        }
    }
    
    // Print all students in order of addition
    public void printGradebook(String ID) {
        if (studentGrades.isEmpty()) {
            System.out.println("The gradebook is empty.");
        } else if(studentGrades.containsKey(ID)) {
            System.out.println("Student not found");
        }
        else {
            for(i=0; i<studentGrades.get(ID).size(); i++) {
                System.out.print(studentGrades.get(ID).get(i) + " ");
            }
        }
    }


}