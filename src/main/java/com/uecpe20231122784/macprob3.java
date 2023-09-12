package com.uecpe20231122784;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class macprob3 {
    private static String _sp(int n) {
        String space = "";
        for (int i = 0; i < n - 1; i++) {
            space = space + " ";
        }
        return space;
    }

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
        double penny_value = 0.01;
        // double initial_salary = 1;
        

        Scanner stdin = new Scanner(System.in);
        int days_worked = Integer.parseInt(stdin.nextLine());
        double[] salary_array = new double[days_worked];
        salary_array[0] = 1.0;

        System.out.printf("--------------------------------%n");
        System.out.printf("         SALARY DATA            %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-4i | %-10d |%n", "Day #", "Salary");
        System.out.printf("| %-4i | %-10d |%n", "Day #", "Salary");
        System.out.printf("--------------------------------%n");

        System.out.printf("| %-10s | %-8s | %04d |%n", "Floating", "double",  64);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Floating", "float",   32);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Integral", "long",    64);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Integral", "int",     32);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Integral", "char",    16);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Integral", "short",   16);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Integral", "byte",    8);
        System.out.printf("| %-10s | %-8s | %04d |%n", "Boolean",  "boolean", 1);

        System.out.printf("--------------------------------%n");

        System.out.println("Salary data:\n|==========|===========|");
        System.out.println("|  Day #   |  Salary   |");
        System.out.println("| " + 1 + _sp(6) + "| " + salary_array[0]);

        for (int i = 1; i < days_worked; i++) {
            salary_array[i] = salary_array[i - 1] * 2;
            System.out.print("| " + i + _sp(7 - Integer.toString(i).length()) + "| " + salary_array[i] + _sp(7 - Double.toString(salary_array[i]).length()) + "|");
        }

        
        System.out.println("|==========|===========|");

        for (int i = 0; i < salary_array.length; i++) {
            
        }
        // System.out.println("|==========|==========|");

    }

}
