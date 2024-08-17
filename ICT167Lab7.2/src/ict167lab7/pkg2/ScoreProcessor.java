/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ict167lab7.pkg2;

import java.io.*;
import java.util.Scanner;

public class ScoreProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();
        Score[] scores = new Score[10];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < scores.length) {
                String[] parts = line.split(" ");
                Score score = new Score();
                score.setName(parts[0]);
                score.setScore(Integer.parseInt(parts[1]));
                scores[index++] = score;
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file.");
            e.printStackTrace();
            return;
        }

        // Calculate statistics
        double total = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (Score score : scores) {
            int sc = score.getScore();
            total += sc;
            if (sc > largest) largest = sc;
            if (sc < smallest) smallest = sc;
        }
        double average = total / scores.length;

        // Write output to CSV
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.csv"))) {
            writer.println(scores.length + "," + average + "," + largest + "," + smallest);
            for (Score score : scores) {
                writer.println(score.getName() + "," + score.getScore());
            }
        } catch (IOException e) {
            System.out.println("Error writing to the output file.");
            e.printStackTrace();
        }
    }
}

