/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

public class BabyClient
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Baby[] babies = new Baby[4];
 
        //prompt user to enter details for each baby
        int index = 0;
        while (index < babies.length)
        {
            System.out.println("Enter details for Baby " + (index + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            babies[index] = new Baby(name, age);
            index++;
        }
 
        //output details of all babies
        System.out.println("\nDetails of all babies:");
        index = 0;
        while (index < babies.length)
        {
             System.out.println("Name: " + babies[index].getName() + ", Age: " + babies[index].getAge());
             index++;
        }
 
        //calculate and display average age of all babies
        double totalAge = 0;
        index = 0;
        while (index < babies.length)
        {
            totalAge += babies[index].getAge();
            index++;
        }
        double averageAge = totalAge / babies.length;
        System.out.printf("Average age of all babies: %.2f\n", averageAge);
 
        //check if any two babies in the array are identical
        boolean foundIdenticalBabies = false;
        index = 0;
        while (index < babies.length)
        {
            int index2 = index + 1;
            while (index2 < babies.length)
            {
                if (babies[index].equals(babies[index2]))
                {
                    System.out.println("Baby " + (index + 1) + " and Baby " + (index2 + 1) + " are identical.");
                    foundIdenticalBabies = true;
                }
                index2++;
            }
            index++;
        }
        if (!foundIdenticalBabies)
        {
            System.out.println("No two babies are identical.");
        }
        scanner.close();
    }
}