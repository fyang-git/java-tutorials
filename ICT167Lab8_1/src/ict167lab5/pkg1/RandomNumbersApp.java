/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab5.pkg1;

import java.util.*;

public class RandomNumbersApp {

    public static void main(String[] args) {
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

        // Sort the numbers using insertion sort and display the sorted array
        sortNumbersUsingInsertionSort(numbers);
        System.out.println("After sorting:");
        printNumbers(numbers);
    }

    public static int[] generateRandomNumbers(int count) {
        Random generator = new Random();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = 1 + generator.nextInt(999);
        }
        return numbers;
    }

    public static int findSmallest(int[] numbers) {
        int smallest = numbers[0];
        for (int num : numbers) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

    public static int findLargest(int[] numbers) {
        int largest = numbers[0];
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static double calculateAverage(int[] numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    public static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Ensure the output ends on a new line.
    }

    public static void sortNumbersUsingInsertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
    }
}
