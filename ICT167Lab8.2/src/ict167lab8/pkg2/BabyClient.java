/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ict167lab8.pkg2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BabyClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baby[] babies = new Baby[4];

        // Patient details
        System.out.println("Enter Patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Identification Number: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        babies[0] = new Patient(name, age, id);

        // Baby details
        System.out.println("Enter Baby details:");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        babies[1] = new Baby(name, age);

        // Playgroup details
        System.out.println("Enter Playgroup details:");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        babies[2] = new Playgroup(name, age);

        // Another Baby details
        System.out.println("Enter another Baby details:");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        babies[3] = new Baby(name, age);

        // Output the details
        try (PrintWriter writer = new PrintWriter(new FileWriter("Baby.txt"))) {
            for (Baby baby : babies) {
                String details = "Name: " + baby.getName() + ", Age: " + baby.getAge();
                if (baby instanceof Patient) {
                    details += ", ID: " + ((Patient) baby).getIdentificationNumber();
                    baby.babySound();
                } else if (baby instanceof Playgroup) {
                    baby.babySound();
                }
                System.out.println(details);
                writer.println(details);
                baby.babySound();
                writer.println("Baby Sound: " + ((baby instanceof Patient) ? "Sick" : (baby instanceof Playgroup) ? "Happy" : "Neutral"));
            }
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }
}

