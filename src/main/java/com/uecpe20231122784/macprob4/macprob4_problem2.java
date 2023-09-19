package com.uecpe20231122784.macprob4;

import com.uecpe20231122784.macprob4.lib.out;
import com.uecpe20231122784.macprob4.lib.cli;
import com.uecpe20231122784.macprob4.lib.rand;

public class macprob4_problem2 {

    public static void main() {
        
        // Program title
        out.println("Rock, Paper, Scissors Game");

        // Declare initial variables/resources
        int option_player;
        int option_computer;
        boolean loop_again = false;

        do {
            // Pre-determine computer option
            option_computer = rand.intByRange(1, 3);

            // Get user input
            out.println("Pick which one to play:");
            out.print("(1) rock   (2) paper   (3) scissors >> ");
            
            try {
                // Wait for player input
                option_player = (int) cli.waitForInput("int");
                
                // Check if player option is within bounds
                if (validateRpsOption(option_player) == 0) {
                    out.println("<!> ERROR: Invalid input");
                    loop_again = true;
                    continue;
                }

                // Check if draw
                if (arbitrateRpsWinner(option_player, option_computer) == "Draw") {
                    out.println("Player plays " + mapRpsOption(option_player));
                    out.println("Computer plays " + mapRpsOption(option_computer));
                    out.println("It's a " + arbitrateRpsWinner(option_player, option_computer) + ". Let's play again.");
                    // Play again if game is draw
                    loop_again = true;
                }
                // Else, resolve winner
                else {
                    out.println("Player plays " + mapRpsOption(option_player));
                    out.println("Computer plays " + mapRpsOption(option_computer));
                    out.println(arbitrateRpsWinner(option_player, option_computer) + " wins!");
                    loop_again = false;
                }
            } catch (Exception e) {
                // Catch any invalid inputs
                out.println("<!> ERROR: Invalid input");
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

}
