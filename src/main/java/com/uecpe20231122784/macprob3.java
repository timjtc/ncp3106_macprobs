package com.uecpe20231122784;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class macprob3 {

    public static void problem1() {

        // Program title/desc
        System.out.println("Slot Machine Game");

        // Declare initial vars
        Scanner stdin = new Scanner(System.in);
        String[] slot_range = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
        Random rand_in = new Random();
        boolean run_game = true;
        int match;
        int[] slot_result = new int[3];
        double amount_earned = 0.0;
        double bet;
        double total_bet = 0.0;

        while (run_game) {
            
            // Initialize/reset some variables
            match = 0;
            
            // Get amount of bet from user
            System.out.println("=== === ===");
            System.out.print("How much do you want to bet?  $ ");
            bet = Double.parseDouble(stdin.nextLine());
            total_bet = total_bet + bet;
            
            // Roll for results
            for (int i = 0; i < slot_result.length; i++) {
                slot_result[i] = rand_in.nextInt(6);
            }

            // Print results
            System.out.println(slot_range[slot_result[0]] + " | " + slot_range[slot_result[1]] + " | " + slot_range[slot_result[2]]);

            // For each slot item,
            for (int i = 0; i < slot_range.length; i++) {
                // Set match counter to 0 at first/again
                match = 0;
                
                // Iterate over the results array...
                for (int j = 0; j < slot_result.length; j++) {
                    // if the result matches the slot item
                    match = (slot_result[j] == i) ? match + 1 : match;
                }
                // If it does,
                if (match > 1) {
                    // accumulate amount earned...
                    amount_earned = amount_earned + (bet * (double) match);
                    // print output and break from loop
                    System.out.println("Congratulations! You won " + match + " times of the money you entered!");
                    System.out.println("Total earnings: $" + amount_earned);
                    break;
                }
            }

            // If no two symbols match, user lose
            if (match < 2) {
                System.out.println("Sorry, you won nothing.");
            }

            // Ask the user if another round will be played
            System.out.print("Do you want to play another game (y/n)? ");
            // If y, loop again. If n, while loop breaks
            run_game = (stdin.nextLine().equalsIgnoreCase("y")) ? true : false;

            // Check if game is to exit, then print total amount won
            if (!run_game) {
                System.out.println("=== === ===\nTotal bet: $" + total_bet + " || Amount won: $" + amount_earned);
            }
            
        }
        
        // CLose scanner
        stdin.close();
        
    }

    public static void problem2() throws IOException {
        
        // Print program title
        System.out.println("String Case Converter");

        // Get filenames
        Scanner stdin = new Scanner(System.in);
        System.out.print("Filename of the file to read: ");
        String filename_read = stdin.nextLine();
        System.out.print("Filename of the file to write to: ");
        String filename_write = stdin.nextLine();

        // Initialize PrintWriter
        PrintWriter stdout = new PrintWriter(new FileWriter(filename_write));

        // Initialize Scanner for reading file
        try (Scanner in = new Scanner(new File(filename_read))) {

            // Loop until the file has contents
            while (in.hasNext()) {

                // Write each line as uppercase string
                stdout.write((in.nextLine() + '\n').toUpperCase());
                if (stdout.checkError()) {
                    System.out.println("ERROR: An error occurred while writing to file!");
                    System.exit(102);
                }

            }

        } catch (FileNotFoundException e) {
            // If file is not found, return an error
            System.out.print("ERROR: File to read not found!");
            System.exit(101);
        }

        // Inform user
        System.out.println("Converted input to uppercase.");

        // Close resources
        stdin.close();
        stdout.close();
        
    }

    public static void problem3() {
        
        // Program title
        System.out.println("Payroll Calculator");

        // Initialize values
        double penny_value = 0.01;
        int days_worked = 0;
        Scanner stdin = new Scanner(System.in);
        boolean input_invalid = true;
        
        // Get user input
        while (input_invalid) {
            System.out.print("Compute salary for how many days? ");
            days_worked = Integer.parseInt(stdin.nextLine());
            // Check if user input is below 1
            if (days_worked < 1) {
                // Keep looping if input is invalid
                input_invalid = true;
                System.out.println("Please input a number at least 1.");
            }
            else {
                // Set invalid flag to false if input is correct
                input_invalid = false;
            }
        }
        double[] salary_array = new double[days_worked];

        // Print data in a table using formatting
        System.out.printf("----------------------------%n");
        System.out.printf("|       SALARY DATA        |%n");
        System.out.printf("|-------+------------------|%n");
        System.out.printf("| %-4s |    %-10s    |%n", "Day #", "Salary");
        System.out.printf("|-------+------------------|%n");
        // For each day, multiply the value of penny in USD to number of pennies earned per day
        for (int i = 0; i < days_worked; i++) {
            salary_array[i] = (i == 0) ? 1.0 : salary_array[i - 1] * 2;
            System.out.printf("|  %-4s | $%-15s |%n", Integer.toString(i + 1), Double.toString(salary_array[i] * penny_value));
        }
        System.out.printf("----------------------------%n");

        // Close resources
        stdin.close();

    }

    public static void problem4() {
        
    }

}
