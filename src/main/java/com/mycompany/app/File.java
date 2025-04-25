package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;

public class File {
    
    /**
     * Read a file
     * CWE-459: Incomplete Cleanup
     * CWE-835: Loop with Unreachable Exit Condition ('Infinite Loop')
     * CWE-248: Uncaught Exception
     * @param filename
     */
    public Course readFile(String filename) throws FileNotFoundException, IOException {
        //try with resources. Closes the file automatically
        //Read file line by line
        ArrayList<Student> studentList = new ArrayList<Student>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String courseName="";
            String courseID="";
            Teacher teacher = null;

            while ((line = br.readLine()) != null) {
                //Course
                //number of students
                int numOfStudents = Integer.parseInt(line);
                int numOfAssignments = Integer.parseInt(line);
                br.readLine();
                String courseLine = br.readLine();
                String[] arr = courseLine.split(": ");
                System.out.println(courseLine);
                 courseID = arr[0];
                 courseName = arr[1];
                 String teacherLine = br.readLine();
                 String arraryForTeacher[] = teacherLine.split(" ");
                 String garbage = arraryForTeacher[0];
                 String teacherFirstName = arraryForTeacher[1];
                 String teacherLastName = arraryForTeacher[2];
                //Create a new teacher object
                 teacher = new Teacher(teacherFirstName, teacherLastName);
                //Student
                
                Course course = new Course(courseName, courseID, studentList, teacher);
                for(int i=0; i <numOfStudents; i++){
                    String studentLine = br.readLine();
                    studentLine.replaceAll("[\\[\\]]", "").trim();
                    String[] arr2 = studentLine.split(" ");
                    String studentID = arr2[0];
                    String firstName = arr2[1];
                    String lastName = arr2[2];
                    //Create a new student object
                    Student student = new Student(firstName, lastName, studentID);
                    //Add the student to the course
                    int maxGradesToRead = Math.min(numOfAssignments, arr2.length - 3);
                    for(int j =3; j < maxGradesToRead +3; j++){
                       //add assignment grades to gradebook
                       int grade = Integer.parseInt(arr2[j]);
                       course.addSingleGrade(student, grade);
                    }
                    
                    course.addStudent(student);

                }
                return course;
            }
            //Catch any exceptions that occur with an error message
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.err.println("" + e.getMessage());
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            System.err.println("" + e.getMessage()); 
            throw new IOException(e.getMessage());
        } 
        return null;

    }
    /**
     * Function to write a file
     * CWE-248: Uncaught Exception
     * CWE-390: Detection of Error Condition Without Action
     * CWE-459: Incomplete Cleanup
     * @param course
     * @throws IOException
     * @throws Exception
     */
    public void writeFile(Course course)throws IOException {
        if(course == null){
            throw new NullPointerException("Course is null");
        }
        String filename = course.getCourseName() + ".txt";
        //try with resources. Closes the file automatically
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            //Need a custom toString method in Course
            bw.write(course.toString());
            //Catch any exceptions that occur
        } catch (IOException e) {
            System.err.println("Error writing file: " + course.getCourseName() + ".txt");
            System.err.println("" + e.getMessage());
            throw new IOException(e.getMessage());
        } 
    }

}  