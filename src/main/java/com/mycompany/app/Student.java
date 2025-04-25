package com.mycompany.app;

public class Student {
     private String studentID;
     private String firstName;
     private String lastName;
   
     /**
      * The Constructor for the student class
      * 
      *  @param fName student's first Name
      *  @param lName student's last Name
      *  @param ID student's ID
      */
     public Student(String fName, String lName, String ID) {
      studentID = ID;
      firstName = fName;
      lastName = lName;
     }

     /**
      *  Gets the student ID
      * 
      *  @return returns the ID of student
      */
     public String getStudentID() {
      return studentID;
     }
     /**
      *  Sets the student ID
      * 
      *  @return returns the ID of new student
      */
     public void setStudentID(String studentID) {
      this.studentID = studentID;
    }
     /**
      *  Gets the firstName of the student 
      * 
      *  @return returns the firstName of student
      */
     public String getFirstName() {
      return firstName;
     }
     /**
      *  Sets the firstName of the student
      * 
      *  @return returns the new firstName of student
      */
     public void setFirstName(String firstName) {
      this.firstName = firstName;
     }
     /**
      * Gets the lastName of the student
      * 
      *  @return returns the lastName of student
      */
     public String getLastName() {
      return lastName;
     }
     /**
      *  Sets the lastName of the student 
      * 
      *  @return returns the new lastName of student 
      */
     public void setLastName(String lastName) {
      this.lastName = lastName;
     }

}
