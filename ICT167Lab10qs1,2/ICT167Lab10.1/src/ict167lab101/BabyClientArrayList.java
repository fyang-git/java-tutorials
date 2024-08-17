/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab101;

import java.util.ArrayList;
import java.util.Scanner;

public class BabyClientArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Baby> babies = new ArrayList<>();

        // a) Enter details for each baby
        System.out.println("Enter details for 4 babies:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            babies.add(new Baby(name, age));
        }

        // b) Calculate and display the average age of all babies
        double totalAge = babies.stream().mapToInt(Baby::getAge).sum();
        double averageAge = totalAge / babies.size();
        System.out.printf("Average age: %.2f\n", averageAge);

        // c) Ask the user to enter the name of a baby, then remove it
        System.out.print("Enter the name of a baby to remove: ");
        String nameToRemove = scanner.nextLine();
        babies.removeIf(baby -> baby.getName().equalsIgnoreCase(nameToRemove));

        // d) Allow the user to add new baby information
        System.out.println("Enter details for a new baby:");
        System.out.print("Name: ");
        String newName = scanner.nextLine();
        System.out.print("Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        babies.add(new Baby(newName, newAge));

        // e) Output the details of each baby
        System.out.println("Details of all babies:");
        for (Baby baby : babies) {
            System.out.println("Name: " + baby.getName() + ", Age: " + baby.getAge());
        }

        scanner.close();
    }
}

