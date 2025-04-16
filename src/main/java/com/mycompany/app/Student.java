package com.mycompany.app;

public class Student {
   private String studentID;
   private String firstName;
   private String lastName;
   
   public Student(String fName, String lName, String ID) {
     studentID = ID;
     firstName = fName;
     lastName = lName;
   }

   public String getStudentID() {
    return studentID;
   }

   public void setStudentID(String studentID) {
    this.studentID = studentID;
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
