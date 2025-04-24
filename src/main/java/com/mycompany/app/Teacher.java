package com.mycompany.app;

//Import Statement for ArrayList
import java.util.ArrayList;

public class Teacher {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courseList;

    // A Constructor for the Teacher class
    public Teacher(String fName, String lName){
     firstName = fName;
     lastName = lName;
     courseList = new ArrayList<>();
    }

    //Getter and setter for firstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    //Getter and setter for LastNmae
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // A method to add a course for a teacher
    public void addCourse(Course course) {
        courseList.add(course);
    }
    
    // A method to remove a course for a teacher
    public void removeCourse(Course course) {
        courseList.remove(course);
    }
    
}