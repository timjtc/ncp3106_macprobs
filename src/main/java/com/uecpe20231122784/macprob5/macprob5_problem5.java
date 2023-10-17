package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob5_problem5 {
    public static void main(String[] args) {
        
        // Initialize Die class variable
        Die d6_player = new Die(6);
        Die d6_computer = new Die(6);

        // Define input return values
        String[][] VAL_ARRAY = {{"y", "true"}, {"n", "false"}};

        // Initialize value holder variables
        int hand_player = 0;
        int hand_computer = 0;
        boolean did_computer_bust = false;
        boolean did_player_bust = false;
        boolean will_player_roll = true;

        for (int round = 1; will_player_roll; round++) {

            // Print round number
            print.ln("Round " + round);

            // Initial roll
            if (round == 1) {

                print.ln("Initial roll");

                // Roll both dice for players and accumulate on variable
                d6_player.roll();
                d6_computer.roll();
                hand_player += d6_player.getValue();
                hand_computer += d6_computer.getValue();

                // Show initial hand
                print.ln("Your hand: " + hand_player);
                print.ln("--- --- --- --- ---");

                // Skip iteration
                continue;
            }

            /*
             * Implementation of a simple game strategy for computer:
             *  Computer only has a 1/6 chance of rolling when its hand exceeds 15
             */
            if (hand_computer < 16) {
                // Always roll if computer's hand is less than 16
                d6_computer.roll();
                hand_computer += d6_computer.getValue();
                print.ln("Computer rolls.");
            }
            else {
                /*
                * If hand exceeds 15:
                *  Generate a random decision that has a 1/6 chance of occuring 
                *  for computer if it will roll or not
                */
                d6_computer.roll();
                if (d6_computer.getValue() < 2) {
                    d6_computer.roll();
                    hand_computer += d6_computer.getValue();
                    print.ln("Computer rolls.");
                }
                else {
                    print.ln("Computer rejects to roll.");
                }
            }

            // Check if computer busts over 21
            if (hand_computer > 21) {
                did_computer_bust = true;
                print.ln("Computer busts! Player wins!");
                break;
            }

            // Ask input if player will roll
            will_player_roll = Boolean.parseBoolean(input.vstring("Roll the die (y/n)? ", VAL_ARRAY));

            // If player rolls, accumulate on variable
            if (will_player_roll) {
                d6_player.roll();
                hand_player += d6_computer.getValue();
            }
            print.ln("Your hand: " + hand_player);

            // Check if player busts
            if (hand_player > 21) {
                did_player_bust = true;
                print.ln("Player busts! Computer Wins!");
                break;
            }

            // CLI round separator
            print.ln("--- --- --- --- ---");
        }

        // Declare winner
        if (!did_computer_bust && !did_player_bust && (hand_player > hand_computer)) {
            print.ln("Player wins!");
        }
        else if (!did_computer_bust && !did_player_bust && (hand_player == hand_computer)) {
            print.ln("Tie!");
        }
        else if (!did_computer_bust && !did_player_bust && (hand_computer > hand_player)) {
            print.ln("Computer wins!");
        }

        // Show total hand at the end
        print.ln("Player's hand: " + hand_player);
        print.ln("Computer's hand: " + hand_computer);
        
        
    }

}
