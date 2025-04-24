package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.ArrayList;

public class GradeBook {
    //I have tried storing each students grades and ID's with HashMap.
    private HashMap<String, ArrayList<Integer>> studentGrades;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        studentGrades = new HashMap<>();
    }

    //Adds a new student
    public void addStudent(String ID) {
        if (!studentGrades.containsKey(ID)) {
            studentGrades.put(ID, new ArrayList<Integer>());
            return true;
        } else {
            System.out.println("Student already exists");
            return false;
        }
    }

    public void addGrade(String ID, Integer grade) {
        if (!studentGrades.containsKey(ID)) {
            System.out.println("Student not found");
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
    public List<Integer> getGrades(String ID) {
        return studentGrades.get(ID);
    }

    /* Updates a specific grade for a student
     * First I have checked if the student exists
     * Then checked if the index is valid, If it is valid, Updates the grade in the list.
    */
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

    
    /* This method helped in printing all the grades for a student
     * First I have checked if the gradebook is empty
     * Then checked if the student exists
     * After passing both the checks I made it loop through the grade list and print the grades.
     */
    public void printGradebook(String ID) {
        if (studentGrades.isEmpty()) {
            System.out.println("The gradebook is empty.");
        } else if(!studentGrades.containsKey(ID)) {
            System.out.println("Student not found");
        }
        else {
            for(int i=0; i<studentGrades.get(ID).size(); i++) {
                System.out.print(studentGrades.get(ID).get(i) + " ");
            }
        }
    }


}