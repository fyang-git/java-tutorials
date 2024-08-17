/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167lab8.pkg2;

public class Baby {
    private String name;
    private int age;

    public Baby() {
    }

    public Baby(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void babySound() {
        System.out.println("Baby Sound is Neutral");
    }

    public boolean equals(Baby otherBaby) {
        return this.name.equalsIgnoreCase(otherBaby.getName()) && this.age == otherBaby.getAge();
    }
}

class Patient extends Baby {
    private int identificationNumber;

    public Patient(String name, int age, int identificationNumber) {
        super(name, age);
        this.identificationNumber = identificationNumber;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public void babySound() {
        System.out.println("Baby Sound is Sick");
    }

    public boolean equals(Patient otherPatient) {
        return this.identificationNumber == otherPatient.getIdentificationNumber();
    }
}

class Playgroup extends Baby {
    public Playgroup(String name, int age) {
        super(name, age);
    }

    @Override
    public void babySound() {
        System.out.println("Baby Sound is Happy");
    }
}
