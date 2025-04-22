/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner in = new Scanner(System.in);
    private static File fileManager = new File();
    private static ArrayList<Course> courseList = new ArrayList<Course>();

    private static int getMainInput() {
        System.out.println("1. Import another couser.");
        System.out.println("2. Edit course.");
        System.out.println("3. Input new assignment.");
        System.out.println("4. Update student grade.");
        System.out.println("5. Get student grade.");
        System.out.println("0. Exit.");

        System.out.print("Enter your selection. ");

        int ret = in.nextInt();
        in.nextLine();

        return ret;
    }

    public static void main(String[] args) {

        System.out.print("Do you want to load a file from disk? (y/N) ");
        String inputString = in.nextLine();

        if (inputString.toUpperCase().equals("Y")) {
            importCourse();
        }

        boolean succesfullExit = false;

        while (!succesfullExit) {
            int userSelection = getMainInput();

            switch (userSelection) {
                case 1:
                    importCourse();
                    break;
                case 2:
                    EditCourse();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    succesfullExit = ExitProgram();
                    break;
                default:
                    break;
            }
        }

        in.close();
    }

    private static void EditCourse() {
        String editInput;
        System.out.println("Select an option:\n1.Print courses.\n2. Enter course id.\n0. Go to previous menu.");

        boolean exit = false;

        while (!exit) {
            int menuSelection = in.nextInt();
            in.nextLine();

            switch (menuSelection) {
                case 1:
                    PrintCourses();
                    break;
                case 2:
                    System.out.print("Enter course name. ");
                    editInput = in.nextLine();
                    Course course = findCourse(editInput);
                    if (course == null) {
                        System.out.println("Course does not exits");
                        return;
                    }
                    System.out.print("Enter new course name. ");
                    String newName = in.nextLine();

                    // todo
                    // course.updateName(newName);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Enter a valid value.");
            }
        }

    }

    private static Course findCourse(String id) {
        for (int i = 0; i < courseList.size(); i++) {
            Course curCourse = courseList.get(i);
            // CWE-476
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

    private static void importCourse() {
        System.out.print("Name of file to import? ");
        String inputString = in.nextLine();
        try {
            Course currentCourse = fileManager.readFile(inputString);
            if (currentCourse != null) {
                courseList.add(currentCourse);
            }
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                importCourse();
                return;
            } else {
                System.out.println("Exiting the program.");
                System.exit(1);
            }

        }
    }
}
