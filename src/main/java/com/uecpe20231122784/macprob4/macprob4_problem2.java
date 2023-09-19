package com.uecpe20231122784.macprob4;

import java.util.Random;
import java.util.Scanner;

public class macprob4_problem2 {

    public static void main() {
        
        // Program title
        println("Rock, Paper, Scissors Game");

        // Declare initial variables/resources
        Scanner stdin = new Scanner(System.in);
        Random random = new Random();
        int option_player;
        int option_computer;
        boolean loop_again = false;

        do {
            // Pre-determine computer option
            option_computer = randInt(random, 1, 3);

            // Get user input
            println("Pick which one to play:");
            print("(1) rock   (2) paper   (3) scissors >> ");
            
            try {
                // Wait for player input
                option_player = (int) waitForInput(stdin, "int");
                
                // Check if player option is within bounds
                if (validateRpsOption(option_player) == 0) {
                    println("<!> ERROR: Invalid input");
                    loop_again = true;
                    continue;
                }

                // Check if draw
                if (arbitrateRpsWinner(option_player, option_computer) == "Draw") {
                    println("Player plays " + mapRpsOption(option_player));
                    println("Computer plays " + mapRpsOption(option_computer));
                    println("It's a " + arbitrateRpsWinner(option_player, option_computer) + ". Let's play again.");
                    // Play again if game is draw
                    loop_again = true;
                }
                // Else, resolve winner
                else {
                    println("Player plays " + mapRpsOption(option_player));
                    println("Computer plays " + mapRpsOption(option_computer));
                    println(arbitrateRpsWinner(option_player, option_computer) + " wins!");
                    loop_again = false;
                }
            } catch (Exception e) {
                // Catch any invalid inputs
                println("<!> ERROR: Invalid input");
                loop_again = true;
            }
        } while (loop_again);

    }

    public static String arbitrateRpsWinner(int player_option, int computer_option) {
        if ((computer_option == player_option - 1) || (computer_option == player_option + 2)) {
            return "Player";
        }
        else if (player_option == computer_option) {
            return "Draw";
        }
        else {
            return "Computer";
        }
    }

    public static String mapRpsOption(int option) {
        switch (option) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return "invalid";
        }
    }

    public static int validateRpsOption(int option) {
        return ((option < 1 || option > 3) ? 0 : option);
    }

    public static <PrintableToString> void println(PrintableToString... args) {
        for (PrintableToString pts : args) {
            System.out.print(pts);
        }
        System.out.println();
    }

    public static <PrintableToString> void print(PrintableToString... args) {
        for(PrintableToString pts: args) {
            System.out.print(pts);
        }
            
    }

    public static int randInt(Random r, int min, int max) {
        int rand = r.nextInt((max - min) + 1) + min;
        return rand;
    }

    public static Object waitForInput(Scanner scanner, String type) {
        String i = scanner.nextLine();
        switch (type) {
            case "int":
                return Integer.parseInt(i);
            case "double":
                return Double.parseDouble(i);
            case "float":
                return Float.parseFloat(i);
            case "boolean":
                return Boolean.parseBoolean(i);
            default:
                return i;
        }
    }

}
