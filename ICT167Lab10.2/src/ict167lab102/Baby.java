/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167lab102;

public class Baby {
    private String name;
    private int age;

    // Default constructor
    public Baby() {
        this.name = "Default Name";
        this.age = 1; // Setting a default age
    }

    // Constructor with parameters
    public Baby(String name, int age) {
        setName(name); // Using the setter to enforce name validation
        setAge(age); // Using the setter to enforce age validation
    }

    // Setter for name
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Default Name"; // Default name if input is invalid
        }
    }

    // Setter for age
    public void setAge(int age) {
        if (age >= 1 && age <= 12) {
            this.age = age;
        } else {
            this.age = 0; // Default age if input is out of range
        }
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Equals method
    public boolean equals(Baby otherBaby) {
        if (otherBaby == null) {
            return false;
        }
        return this.name.equalsIgnoreCase(otherBaby.getName()) && this.age == otherBaby.getAge();
    }
}
