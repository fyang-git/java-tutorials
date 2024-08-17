/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167assignment2;

import java.util.*;

// Base class: Student
class Student {
    private String firstName;
    private String lastName;
    private long studentNumber;

    // Default constructor
    public Student() {}

    // Constructor with parameters
    public Student(String firstName, String lastName, long studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    // Getters and Setters
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

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    // Method to report grade
    public void reportGrade() {
        System.out.println("There is no grade here.");
    }

    // Method to compare student objects by student number
    public boolean equals(Student other) {
        return this.studentNumber == other.studentNumber;
    }
}

// Derived class: Student_Course
class Student_Course extends Student {
    private String enrolmentType;

    public Student_Course(String firstName, String lastName, long studentNumber, String enrolmentType) {
        super(firstName, lastName, studentNumber);
        this.enrolmentType = enrolmentType;
    }

    // Method to report grade for course work students
    @Override
    public void reportGrade() {
        System.out.println("C, " + getFirstName() + " " + getLastName() + ", Student Number: " + getStudentNumber() +
                ", Unit ID: " + getUnitID() + ", Overall Mark: " + calculateOverallMark() +
                ", Final Grade: " + calculateFinalGrade());
    }

    // Dummy method for unit ID - to be overridden in Unit_Course
    public String getUnitID() {
        return "Not available";
    }

    // Dummy method for calculating overall mark - to be overridden in Unit_Course
    public double calculateOverallMark() {
        return -1;
    }

    // Dummy method for calculating final grade - to be overridden in Unit_Course
    public String calculateFinalGrade() {
        return "Not available";
    }
    
    public String getEnrolmentType() {
    return enrolmentType;
    }
}

// Derived class: Student_Research
class Student_Research extends Student {
    private String enrolmentType;

    public Student_Research(String firstName, String lastName, long studentNumber, String enrolmentType) {
        super(firstName, lastName, studentNumber);
        this.enrolmentType = enrolmentType;
    }

    // Method to report grade for research students
    @Override
    public void reportGrade() {
        System.out.println("R, " + getFirstName() + " " + getLastName() + ", Student Number: " + getStudentNumber() +
                ", Overall Mark: " + calculateOverallMark() + ", Final Grade: " + calculateFinalGrade());
    }

    // Dummy method for calculating overall mark - to be overridden in Research
    public double calculateOverallMark() {
        return -1;
    }

    // Dummy method for calculating final grade - to be overridden in Research
    public String calculateFinalGrade() {
        return "Not available";
    }
    
    public String getEnrolmentType() {
    return enrolmentType;
    }
}

// Base class: Unit
class Unit {
    private String enrolmentType;

    public Unit(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    // Method to report final grade
    public void reportFinalGrade() {
        System.out.println("NA");
    }
}

// Derived class: Unit_Course
class Unit_Course extends Unit {
    private String unitID;
    private int level;
    private double assignment1Mark;
    private double assignment2Mark;
    private double finalExamMark;

    public Unit_Course(String enrolmentType, String unitID, int level, double assignment1Mark, double assignment2Mark, double finalExamMark) {
        super(enrolmentType);
        this.unitID = unitID;
        this.level = level;
        this.assignment1Mark = assignment1Mark;
        this.assignment2Mark = assignment2Mark;
        this.finalExamMark = finalExamMark;
    }

    // Method to report final grade for course work unit
    @Override
    public void reportFinalGrade() {
        System.out.println("Unit ID: " + unitID + ", Final Grade: " + calculateFinalGrade());
    }

    // Method to calculate overall mark for course work unit
    public double calculateOverallMark() {
        return (assignment1Mark + assignment2Mark + finalExamMark) / 3;
    }

    // Method to calculate final grade for course work unit
    public String calculateFinalGrade() {
        double overallMark = calculateOverallMark();
        if (overallMark >= 80) {
            return "HD";
        } else if (overallMark >= 70) {
            return "D";
        } else if (overallMark >= 60) {
            return "C";
        } else if (overallMark >= 50) {
            return "P";
        } else {
            return "N";
        }
    }
}

// Derived class: Research
class Research extends Unit {
    private double proposalMark;
    private double dissertationMark;

    public Research(String enrolmentType, double proposalMark, double dissertationMark) {
        super(enrolmentType);
        this.proposalMark = proposalMark;
        this.dissertationMark = dissertationMark;
    }

    // Method to report final grade for research unit
    @Override
    public void reportFinalGrade() {
        System.out.println("Final Grade: " + calculateFinalGrade());
    }

    // Method to calculate overall mark for research unit
    public double calculateOverallMark() {
        return (0.35 * proposalMark) + (0.65 * dissertationMark);
    }

    // Method to calculate final grade for research unit
    public String calculateFinalGrade() {
        double overallMark = calculateOverallMark();
        if (overallMark >= 80) {
            return "HD";
        } else if (overallMark >= 70) {
            return "D";
        } else if (overallMark >= 60) {
            return "C";
        } else if (overallMark >= 50) {
            return "P";
        } else {
            return "N";
        }
    }
}


