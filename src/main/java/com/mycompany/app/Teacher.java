package com.mycompany.app;

//Import Statement for ArrayList
import java.util.ArrayList;

public class Teacher {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courseList;

    /**
     * The Constructor for the teacher class
     * 
     *  @param fName teacher's first Name
     *  @param lName teacher's last Name
     */
    public Teacher(String fName, String lName){
     firstName = fName;
     lastName = lName;
     courseList = new ArrayList<>();
    }

    /**
     *  Gets the firstName of the teacher 
     * 
     *  @return returns the firstName of teacher
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *  Sets the firstName of the teacher
     * 
     *  @return returns the new firstName of teacher
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the lastName of the teacher
     * 
     *  @return returns the lastName of teacher
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *  Sets the lastName of the teacher 
     * 
     *  @return returns the new lastname of teacher
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Adds a course to the teacher's course list.
     *
     * @param course course to add
     */
    public void addCourse(Course course) {
        courseList.add(course);
    }
    /**
     * Removes a course from the teacher's course list.
     *
     * @param course course to remove
     */
    public void removeCourse(Course course) {
        courseList.remove(course);
    }
    
}