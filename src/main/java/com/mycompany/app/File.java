package com.mycompany.app;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class File {
    
    List<String> fileList = new ArrayList<String>();

    /**
     * Read a file
     * CWE-459: Incomplete Cleanup
     * CWE-835: Loop with Unreachable Exit Condition ('Infinite Loop')
     * CWE-248: Uncaught Exception
     * @param filename
     */
    public void readFile(String filename) throws FileNotFoundException, IOException, Exception {
        //try with resources. Closes the file automatically
        //Read file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
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
        } catch (Exception e) {
            System.err.println("An error occurred.");
            System.err.println("" + e.getMessage());
            throw new Exception(e.getMessage());
       }

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
    public void writeFile(Course course)throws IOException, Exception {
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
        } catch (Exception e) {
            System.err.println("An error occurred:");
            System.err.println("" + e.getMessage());
            throw new Exception(e.getMessage());
        }
        //Add to fileList
        fileList.add(filename);
    }

    /**
     * Retrieve a file based on the course name
     * @param course
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public void retrieveFile(Course course) throws FileNotFoundException, IOException, Exception {
        //Search for file in the list, If not found, throw an exception
        String filename = searchFileName(course);
        //If the file is found, read it
        readFile(filename);

    }
    /**
     * Search for the file name based on the course name
     * CWE-252: Unchecked Return Value
     * @param course
     * @return
     * @throws FileNotFoundException
     */
   public String searchFileName(Course course)throws FileNotFoundException {
    //Search for the file name based on the course name
    if(course == null){
        throw new NullPointerException("Course is null");
    }
    String courseName = course.getCourseName();
    for (String file : fileList) {
        if (file.equals(courseName + ".txt")) {
            return file;
        }
    }
    //Throw an exception if the file is not found
    throw new FileNotFoundException("File was not found. ");
   }
}