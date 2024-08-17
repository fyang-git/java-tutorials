/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167assignment2;

import java.io.*;
import java.util.*;

public class Client {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudentsFromCSV("students.csv");
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Quit");
            System.out.println("2. Add student marks information from CSV file");
            System.out.println("3. Remove student");
            System.out.println("4. Output all student details");
            System.out.println("5. Analyze course work student marks");
            System.out.println("6. Report grade for a student");
            System.out.println("7. Sort student list by ID");
            System.out.println("8. Output sorted student list to CSV");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Exiting the program...");
                    break;
                case 2:
                    addStudentFromCSV();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    analyzeCourseWorkStudents();
                    break;
                case 6:
                    reportStudentGrade();
                    break;
                case 7:
                    sortStudentsByID();
                    break;
                case 8:
                    outputSortedStudentsToCSV();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 8.");
            }
        } while (choice != 1);
        scanner.close();
    }

    public static void loadStudentsFromCSV(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            // Parse shared student details
            String type = data[0].trim();
            String firstName = data[1].trim();
            String lastName = data[2].trim();
            long studentNumber = Long.parseLong(data[3].trim());

            if (type.equals("C")) { // Coursework student
                // Assuming the CSV format for coursework students includes unit details and marks
                String unitID = data[4].trim();
                int level = Integer.parseInt(data[5].trim());
                double assignment1Mark = Double.parseDouble(data[6].trim());
                double assignment2Mark = Double.parseDouble(data[7].trim());
                double finalExamMark = Double.parseDouble(data[8].trim());
                Unit_Course unitCourse = new Unit_Course("C", unitID, level, assignment1Mark, assignment2Mark, finalExamMark);
                students.add(new Student_Course(firstName, lastName, studentNumber, unitCourse));
            } else if (type.equals("R")) { // Research student
                // Assuming the CSV format for research students includes proposal and dissertation marks
                double proposalMark = Double.parseDouble(data[4].trim());
                double dissertationMark = Double.parseDouble(data[5].trim());
                Research researcher = new Research("R", proposalMark, dissertationMark);
                students.add(new Student_Research(firstName, lastName, studentNumber, researcher));
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.out.println("Error reading from CSV file: " + e.getMessage());
    }
}

    public static void addStudentFromCSV() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV file name: ");
        String fileName = scanner.nextLine();
        loadStudentsFromCSV(fileName);
    }

    public static void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student number to remove: ");
        long studentNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber() == studentNumber) {
                Student removedStudent = students.remove(i);
                System.out.println("Student removed: " + removedStudent.getFirstName() + " " +
                        removedStudent.getLastName() + " (ID: " + removedStudent.getStudentNumber() + ")");
                return;
            }
        }
        System.out.println("Student with ID " + studentNumber + " not found.");
    }

    public static void displayAllStudents() 
    {
        for (Student student : students) {
            student.reportGrade();
        }
    }

    public static void analyzeCourseWorkStudents() {
        int total = 0;
        double sumOverallMarks = 0;
        for (Student student : students) {
            if (student instanceof Student_Course) 
            {
                total++;
                sumOverallMarks += ((Student_Course) student).calculateOverallMark();
            }
        }
        double averageOverallMark = sumOverallMarks / total;
        int aboveAverage = 0;
        int belowAverage = 0;
        for (Student student : students) {
            if (student instanceof Student_Course) {
                double overallMark = ((Student_Course) student).calculateOverallMark();
                if (overallMark >= averageOverallMark) {
                    aboveAverage++;
                } else {
                    belowAverage++;
                }
            }
        }
        System.out.println("Number of course work students above or equal to average overall mark: " + aboveAverage);
        System.out.println("Number of course work students below average overall mark: " + belowAverage);
    }

    public static void reportStudentGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student number to report grade: ");
        long studentNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                student.reportGrade();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentNumber + " not found.");
        }
    }

    public static void sortStudentsByID() {
        // Insertion sort
        for (int i = 1; i < students.size(); i++) {
            Student key = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getStudentNumber() > key.getStudentNumber()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, key);
        }
        System.out.println("Students sorted by ID.");
    }

    public static void outputSortedStudentsToCSV() {
    try (FileWriter writer = new FileWriter("sorted_students.csv")) {
        for (Student student : students) {
            String type = student instanceof Student_Course ? "C" : "R";
            // Assuming you add methods to get unitID or equivalent for research students
            String unitIDOrEquivalent = student instanceof Student_Course ? ((Student_Course) student).getUnitID() : "N/A";
            writer.write(type + "," + student.getFirstName() + "," + student.getLastName() + "," +
                    student.getStudentNumber() + "," + unitIDOrEquivalent + "\n");
        }
        System.out.println("Sorted students exported to sorted_students.csv");
    } catch (IOException e) {
        System.out.println("Error writing to CSV file: " + e.getMessage());
    }
}

    public static void StudentInfo() {
        System.out.println("Student Details:");
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " (ID: " + student.getStudentNumber() + ", Enrolment Type: " + student.getEnrolmentType() + ")");
        }
    }
}
