package ict167lab7.pkg1;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();
        System.out.print("Enter the name of the output file: ");
        String outputFileName = scanner.nextLine();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length; // Split line into words
                }
                charCount += line.length();
                writer.println(lineCount + " " + line); // Write line to output file with line number
            }
        } catch (FileNotFoundException e) {
            System.out.println("The input file does not exist.");
            return;
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the files.");
            return;
        }

        System.out.println("My name = Fengfan");
        System.out.println("Name of Output file = " + outputFileName);
        System.out.println("Total number of lines in " + inputFileName + " = " + lineCount);
        System.out.println("Total number of words in " + inputFileName + " = " + wordCount);
        System.out.println("Total number of characters in " + inputFileName + " = " + charCount);
    }
}

