package com.mycompany.app;

//Import statements for HashMap and ArrayList.
import java.util.HashMap;
import java.util.ArrayList;

public class GradeBook {
    //I have tried storing each students grades and ID's with HashMap.
    private HashMap<String, ArrayList<Integer>> studentGrades;
    private int numAssignments;

    //A Constructor for the GradeBook class.
    public GradeBook() {
        studentGrades = new HashMap<>();
    }

    /**
     * Adds a new student
     * By using ID
     * If the student already exists it would print a statement
     * 
     * @param ID The student's ID
     * @return true if adding a student is successful
     * @return false if the student already exists
     */
    public boolean addStudent(String ID) {
        if (!studentGrades.containsKey(ID)) {
            studentGrades.put(ID, new ArrayList<Integer>());
            return true;
        } else {
            System.out.println("Student already exists");
            return false;
        }
    }

    /**
     * A method to remove a student from the gradebook
     * 
     * @param ID student's ID
     * @return true if the student was removed
     * @return false when the student doesn't exist
     */
    public boolean removeStudent(String ID) {
        if (studentGrades.containsKey(ID)) {
            studentGrades.remove(ID);
            return true;
        } else {
            System.out.println("Student does not exists in gradebook");
            return false;
        }
    }

    /**
     * A method to add a grade to student's list of grades.
     * 
     * @param ID The student's ID
     * @param grade student's grade to be added
     * @return true if the grade was added
     * @return false if the student is not found
     */
    public boolean addGrade(String ID, Integer grade) {
        if (!studentGrades.containsKey(ID)) {
            System.out.println("Student not found in gradebook");
            return false;
        }
        studentGrades.computeIfPresent(ID, (key, gradeList) -> {
            gradeList.add(grade);
            numAssignments++;
            return gradeList;
        });
        return true;

    }

    /**
     *  returns a student's grades
     * 
     *  @param ID The student's ID
    */
    public ArrayList<Integer> getGrades(String ID) {
        return studentGrades.get(ID);
    }


    /**
     * Updates a specific grade for a student
     * First I have checked if the student exists
     * Then checked if the index is valid, If it is valid, Updates the grade in the list.
     * 
     * @param ID The student's ID
     * @param index To update the index of the grade
     * @param neGrade To replace old grade with a new grade
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

    
    /**
     * This method helped in printing all the grades for a student
     * First I have checked if the gradebook is empty
     * Then checked if the student exists
     * After passing both the checks I made it loop through the grade list and print the grades.
     * 
     * @param ID The student's ID
     */
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

    public int getNumAssignments() {
        return numAssignments;
    }

 }
