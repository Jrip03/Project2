package com.mycompany.app;

public class Student {
   private String studentID;
   private String firstName;
   private String lastName;
   
   // A Constructor for the student class
   public Student(String fName, String lName, String ID) {
     studentID = ID;
     firstName = fName;
     lastName = lName;
   }

   //Getter and setter for studentID
   public String getStudentID() {
    return studentID;
   }
   public void setStudentID(String studentID) {
    this.studentID = studentID;
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

}
