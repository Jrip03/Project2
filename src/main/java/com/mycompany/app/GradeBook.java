package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.ArrayList; 
import java.util.List;

public class GradeBook {
    private HashMap<String, ArrayList<Integer>> studentGrades;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        studentGrades = new HashMap<>();
    }

    // Add a new student with a grade
    public void addStudent(String ID) {
        if (!studentGrades.containsKey(ID)) {
            studentGrades.put(ID, new ArrayList<Integer>());
        } else {
            System.out.println("Student already exists");
        }
    }

    public void addGrade(String ID, Integer grade) {
        if (!studentGrades.containsKey(ID)) {
            System.out.println("Student is not fount");
        } else {
            studentGrades.computeIfPresent(ID, (key, gradeList) -> 
            {
                gradeList.add(grade);
                return gradeList;
            }
            ); 
        }
    }

    // Get a student's grades
    public List<Integer> getGrades(String ID) {
        return studentGrades.get(ID);
    }

    // Update a student's grade at a specific index and reinsert the updated list
    public void updateGrade(String ID, int index, int newGrade) {
        if (studentGrades.containsKey(ID)) {
            ArrayList<Integer> grades = studentGrades.get(ID);
            if (index >= 0 && index < grades.size()) {
                grades.set(index, newGrade);
                studentGrades.put(ID, grades);  
            } else {
                System.out.println("Invalid index for grades list");
            }
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
            for(int i=0; i<studentGrades.get(ID).size(); i++) {
                System.out.print(studentGrades.get(ID).get(i) + " ");
            }
        }
    }


}