package com.mycompany.app;

import java.util.ArrayList;

public class Teacher {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courseList;

    public Teacher(String fName, String lName){
     firstName = fName;
     lastName = lName;
    }

    public String getFirstName() {
        return firstName;
       }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
       }
    
    public String getLastName() {
        return lastName;
       }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
       }

    
    
}