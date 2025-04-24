package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.ArrayList;

public class GradeBook {
    private HashMap<String, ArrayList<Integer>> studentGrades;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        studentGrades = new HashMap<>();
    }

    //Adds a new student
    public boolean addStudent(String ID) {
        if (!studentGrades.containsKey(ID)) {
            studentGrades.put(ID, new ArrayList<Integer>());
            return true;
        } else {
            System.out.println("Student already exists");
            return false;
        }
    }

    public boolean removeStudent(String ID) {
        if (studentGrades.containsKey(ID)) {
            studentGrades.remove(ID);
            return true;
        } else {
            System.out.println("Student does not exists in gradebook");
            return false;
        }
    }

    public boolean addGrade(String ID, Integer grade) {
        if (!studentGrades.containsKey(ID)) {
            System.out.println("Student not found in gradebook");
            return false;
        }
        studentGrades.computeIfPresent(ID, (key, gradeList) -> {
            gradeList.add(grade);
            return gradeList;
        });
        return true;

    }

    // Get a student's grades
    public ArrayList<Integer> getGrades(String ID) {
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
            System.out.println("Student not found in gradebook");
        }
    }

    
    //Print all students in order of addition
    public void printGradebook(String ID) {
        if (studentGrades.isEmpty()) {
            System.out.println("The gradebook is empty.");
        } else if(!studentGrades.containsKey(ID)) {
            System.out.println("Student not found in gradebook");
        }
        else {
            for(int i=0; i<studentGrades.get(ID).size(); i++) {
                System.out.print(studentGrades.get(ID).get(i) + " ");
            }
        }
    }


}