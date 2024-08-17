/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab5.pkg1;

import java.util.*;

public class RandomNumbersApp 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers to generate and store? ");
        int count = scanner.nextInt();

        int[] numbers = generateRandomNumbers(count);
        int smallest = findSmallest(numbers);
        int largest = findLargest(numbers);
        double average = calculateAverage(numbers);

        printNumbers(numbers);
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Largest Number: " + largest);
        System.out.printf("Average: %.2f\n", average);
    }

    public static int[] generateRandomNumbers(int count) 
    {
        Random generator = new Random();
        int[] numbers = new int[count];
        int counter = 0;
        while (counter < count) 
        {
            numbers[counter] = 1 + generator.nextInt(999);
            counter++;
        }
        return numbers;
    }

    public static int findSmallest(int[] numbers) 
    {
        int smallest = numbers[0];
        int index = 1;
        while (index < numbers.length) 
        {
            if (numbers[index] < smallest) 
            {
                smallest = numbers[index];
            }
            index++;
        }
        return smallest;
    }

    public static int findLargest(int[] numbers) 
    {
        int largest = numbers[0];
        int index = 1;
        while (index < numbers.length) 
        {
            if (numbers[index] > largest) 
            {
                largest = numbers[index];
            }
            index++;
        }
        return largest;
    }
    

    public static double calculateAverage(int[] numbers) 
    {
        double sum = 0;
        int index = 0;
        while (index < numbers.length) 
        {
            sum += numbers[index];
            index++;
        }
        return sum / numbers.length;
    }
    

    public static void printNumbers(int[] numbers)
    {
        int counter = 0;
        while (counter < numbers.length) 
        {
            System.out.print(numbers[counter] + " ");
            if ((counter + 1) % 5 == 0) 
            {
                System.out.println();
            }
            counter++;
        }
        System.out.println(); // Ensure the output ends on a new line.
    }
}
    

