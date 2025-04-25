/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner in = new Scanner(System.in);
    private static File fileManager = new File();
    // CWE-766
    private static ArrayList<Course> courseList = new ArrayList<Course>();

    public static void main(String[] args) throws IOException {

        System.out.print("Do you want to load a file from disk? (y/N) ");
        String inputString = in.nextLine();
        if (inputString.toUpperCase().equals("Y")) {
            importCourse();
        }

        boolean succesfullExit = false;

        while (!succesfullExit) {
            System.out.println("1. Import another course.");
            System.out.println("2. Create a new course.");
            System.out.println("3. Edit course.");
            System.out.println("4. Input new assignment.");
            System.out.println("5. Update student grade.");
            System.out.println("6. Get student grade.");
            System.out.println("7. Add student.");
            System.out.println("8. Delete student.");
            System.out.println("9. Save to file.");
            System.out.println("0. Exit.");
            System.out.print("Enter your selection: ");

            int userSelection = in.nextInt();
            in.nextLine();

            switch (userSelection) {
                case 1:
                    importCourse();
                    break;
                case 2:
                    createNewCourse();
                    break;
                case 3:
                    editCourse();
                    break;
                case 4:
                    gradeAssignment();
                    break;
                case 5:
                    editGrade();
                    break;
                case 6:
                    getGrade();
                    break;
                case 7:
                    addStudent();
                    break;
                case 8:
                    deleteStudent();
                    break;
                case 9:
                    saveFile();
                    break;
                case 0:
                    succesfullExit = ExitProgram();
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        }

        in.close();
    }

    private static void getGrade() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Print courses.");
            System.out.println("2. Print students in a course.");
            System.out.println("3. Get student grades.");
            System.out.println("0. Go to previous menu.");

            System.out.print("Enter your selection: ");
            int menuSelection = in.nextInt();
            in.nextLine();

            String editInput;

            switch (menuSelection) {
                case 1:
                    PrintCourses();
                    break;
                case 2:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course = findCourse(editInput);
                    if (course == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    printStudent(course);
                    break;

                case 3:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course3 = findCourse(editInput);
                    if (course3 == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    System.out.print("Enter student id: ");
                    String sName = in.nextLine();

                    Student stu = findStudnet(sName, course3);

                    if (stu == null) {
                        System.out.println("Student does not exits. Try again");
                        return;
                    }

                    System.out.println(course3.getGrades(stu));

                    exit = true;
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
                    exit = true;
                    break;
            }
        }

    }

    private static void editGrade() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Print courses.");
            System.out.println("2. Print students in a course.");
            System.out.println("3. Update studnet grade.");
            System.out.println("0. Go to previous menu.");

            System.out.print("Enter your selection: ");
            int menuSelection = in.nextInt();
            in.nextLine();

            String editInput;

            switch (menuSelection) {
                case 1:
                    PrintCourses();
                    break;
                case 2:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course = findCourse(editInput);
                    if (course == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    printStudent(course);
                    break;

                case 3:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course3 = findCourse(editInput);
                    if (course3 == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    System.out.print("Enter student it: ");
                    String sName = in.nextLine();

                    Student stu = findStudnet(sName, course3);

                    if (stu == null) {
                        System.out.println("Student does not exits. Try again");
                        return;
                    }

                    System.out.print("Enter grade index to update: ");
                    int index = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter new grade: ");
                    int grade = in.nextInt();
                    in.nextLine();

                    course3.editGrade(stu, index, grade);
                    exit = true;
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
                    exit = true;
                    break;
            }
        }

    }

    private static void gradeAssignment() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Print courses.");
            System.out.println("2. Enter course id.");
            System.out.println("0. Go to previous menu.");

            System.out.print("Enter your selection: ");
            int menuSelection = in.nextInt();
            in.nextLine();

            String editInput;

            switch (menuSelection) {
                case 1:
                    PrintCourses();
                    break;
                case 2:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course = findCourse(editInput);
                    in.nextLine();
                    if (course == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    course.gradeAssignment(in);
                    exit = true;
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
                    exit = true;
                    break;
            }
        }
    }

    private static void createNewCourse() {
        System.out.print("Enter profesor first name: ");
        String fName = in.nextLine();
        System.out.print("Enter profesor last name: ");
        String lName = in.nextLine();

        Teacher newT = new Teacher(fName, lName);

        System.out.print("Enter course name: ");
        String cName = in.nextLine();
        System.out.print("Enter course ID: ");
        String cID = in.nextLine();

        Course newC = new Course(cName, cID, new ArrayList<Student>(), newT);

        courseList.add(newC);

        System.out.println("Succesfully added new course.");
    }

    private static void importCourse() throws IOException, FileNotFoundException {
        System.out.print("Name of file to import? ");
        String inputString = in.nextLine();
        // try {
        Course currentCourse = fileManager.readFile(inputString);
        if (currentCourse != null) {
            courseList.add(currentCourse);
        }
        // } catch (Exception e) {
        // if (e instanceof FileNotFoundException) {
        // importCourse();
        // return;
        // } else {
        // System.out.println("Exiting the program.");
        // throw e;
        // }
        // }
    }

    private static void editCourse() {

        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Print courses.");
            System.out.println("2. Enter course id.");
            System.out.println("0. Go to previous menu.");

            System.out.print("Enter your selection: ");
            int menuSelection = in.nextInt();
            in.nextLine();

            String editInput;

            switch (menuSelection) {
                case 1:
                    PrintCourses();
                    break;
                case 2:
                    System.out.print("Enter course id: ");
                    editInput = in.nextLine();
                    Course course = findCourse(editInput);
                    if (course == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    System.out.print("Enter new course id: ");
                    String newName = in.nextLine();

                    course.setCourseName(newName);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
                    exit = true;
                    break;
            }
        }

    }

    private static void saveFile() throws IOException {
        System.out.println("Select an option:");
        System.out.println("1. Print courses.");
        System.out.println("2. Save file");
        System.out.println("0. Go to previous menu.");
        int menuSelection = in.nextInt();
        in.nextLine();

        switch (menuSelection) {
            case 1:
                PrintCourses();
                break;
            case 2:
                System.out.print("Enter ID of course you want to save. ");
                String courseId = in.nextLine();

                Course courseToSave = findCourse(courseId);

                if (courseToSave == null) {
                    System.out.println("Course does not exist. Try again.");
                    return;
                }

                fileManager.writeFile(courseToSave);
                break;
            default:
                System.out.println("Invalid input, try again.");
                break;
        }
    }

    private static void addStudent() {
        System.out.println("Select an option:");
        System.out.println("1. Print courses.");
        System.out.println("2. Add student");
        System.out.println("0. Go to previous menu.");
        System.out.print("Enter selection: ");
        int menuSelection = in.nextInt();
        in.nextLine();

        switch (menuSelection) {
            case 1:
                PrintCourses();
                break;
            case 2:
                System.out.print("Enter course ID of which you want to add a student to: ");
                String courseId = in.nextLine();
                Course courseToEdit = findCourse(courseId);
                if (courseToEdit == null) {
                    System.out.println("Course ID does not exist.");
                    return;
                }
                System.out.print("Enter student first name: ");
                String fName = in.nextLine();
                System.out.print("Enter student last name: ");
                String lName = in.nextLine();
                System.out.print("Enter student id: ");
                String stuId = in.nextLine();
                if (findStudnet(stuId, courseToEdit) != null) {
                    System.out.println("Student allready exists. Can not add");
                    return;
                }
                courseToEdit.addStudent(new Student(fName, lName, stuId));
                System.out.printf("Added %s, %s to student list\n", lName, fName);
                break;

            default:
                System.out.println("Invalid input, try again.");
                break;
        }

    }

    private static void deleteStudent() {
        System.out.println("Select an option:");
        System.out.println("1. Print courses.");
        System.out.println("2. Enter course ID.");
        System.out.println("0. Go to previous menu.");
        int menuSelection = in.nextInt();
        in.nextLine();

        switch (menuSelection) {
            case 1:
                PrintCourses();
                break;
            case 2:
                String courseID = in.nextLine();
                Course courseToEdit = findCourse(courseID);
                if (courseToEdit == null) {
                    System.out.println("Course does not exist");
                }
                printStudent(courseToEdit);
                System.out.print("Enter ID of the student to delete: ");
                String idToDel = in.nextLine();

                if (findStudnet(idToDel, courseToEdit) == null) {
                    System.out.println("Student with this id does not exist. Try again.");
                    return;
                }

                // CWE-357
                System.out.print("Are you sure you want to delete the student? This can't be undone (y/N)");
                if (in.nextLine().toUpperCase().equals("Y")) {
                    courseToEdit.removeStudent(courseToEdit.getStudent(idToDel));
                }
                break;

            default:
                System.out.println("Invalid input, please try again.");
                break;
        }

    }

    private static Student findStudnet(String stuId, Course courseToEdit) {
        ArrayList<Student> students = courseToEdit.getStudentList();
        for (int i = 0; i < students.size(); i++) {
            String stuIDUppder = stuId.toUpperCase();
            String curStuUpper = students.get(i).getStudentID().toUpperCase();
            if (stuIDUppder.equals(curStuUpper)) {
                return students.get(i);
            }
        }
        return null;
    }

    private static void printStudent(Course course) {
        ArrayList<Student> students = course.getStudentList();
        System.out.printf("Students in course %s\n", course.getCourseID());
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            System.out.printf("First name: %s, Last name: %s, ID: %s", stu.getFirstName(), stu.getLastName(),
                    stu.getStudentID());
        }
    }

    private static Course findCourse(String id) {
        for (int i = 0; i < courseList.size(); i++) {
            Course curCourse = courseList.get(i);
            // CWE-476
            // CWE-395????
            if (curCourse == null) {
                continue;
            }

            if (curCourse.getCourseID().toUpperCase().equals(id.toUpperCase())) {
                return curCourse;
            }
        }

        return null;
    }

    private static void PrintCourses() {
        if (courseList.size() == 0) {
            System.out.println("There are currently no courses present.");
            return;
        }

        for (int i = 0; i < courseList.size(); i++) {
            Course curCourse = courseList.get(i);
            if (curCourse == null) {
                continue;
            }
            System.out.printf("Course name: %s. Course ID: %s\n", curCourse.getCourseName(), curCourse.getCourseID());
        }
    }

    private static boolean ExitProgram() {
        // CWE-357
        System.out
                .print("All unsaved progress will be lost, are you user you want to exit the program? (y/N) ");
        boolean properInput = false;

        // CWE-606
        while (!properInput) {
            String inputString = in.nextLine();
            if (inputString.toUpperCase().equals("Y")) {
                System.out.println("Goodbye!");
                return true;
            } else if (inputString.toUpperCase().equals("N")) {
                properInput = true;
            } else {
                System.out.println("Enter y/n.");
            }
        }
        return false;
    }

}