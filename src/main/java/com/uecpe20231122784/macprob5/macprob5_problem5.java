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
        int round_counter = 1;
        boolean did_computer_bust = false;
        boolean did_player_bust = false;
        boolean will_player_roll = true;

        do {
            // Print round number
            print.ln("Round " + round_counter);

            // Initial roll
            if (round_counter == 1) {
                print.ln("Initial roll");
                d6_player.roll();
                d6_computer.roll();
                hand_player += d6_player.getValue();
                hand_computer += d6_computer.getValue();
                print.ln("Your hand: " + hand_player);
                print.ln("--- --- --- --- ---");
                round_counter++;
                continue;
            }

            // Implementation of simple strategy for computer
            if (hand_computer < 16) {
                d6_computer.roll();
                hand_computer += d6_computer.getValue();
                print.ln("Computer rolls.");
            }
            else {
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

            if (hand_computer > 21) {
                did_computer_bust = true;
                print.ln("Computer busts! Player wins!");
                break;
            }

            will_player_roll = Boolean.parseBoolean(input.vstring("Roll the die (y/n)? ", VAL_ARRAY));

            if (will_player_roll) {
                d6_player.roll();
                hand_player += d6_computer.getValue();
                // print.ln("Your hand: " + hand_player);
            }

            print.ln("Your hand: " + hand_player);

            if (hand_player > 21) {
                did_player_bust = true;
                print.ln("Player busts! Computer Wins!");
                break;
            }

            print.ln("--- --- --- --- ---");
            round_counter++;
        } while (will_player_roll);

        if (!did_computer_bust && !did_player_bust && (hand_player > hand_computer)) {
            print.ln("Player wins!");
        }
        else if (!did_computer_bust && !did_player_bust && (hand_player == hand_computer)) {
            print.ln("Tie!");
        }
        else if (!did_computer_bust && !did_player_bust && (hand_computer > hand_player)) {
            print.ln("Computer wins!");
        }

        print.ln("Player's hand: " + hand_player);
        print.ln("Computer's hand: " + hand_computer);
        
        
    }

}
