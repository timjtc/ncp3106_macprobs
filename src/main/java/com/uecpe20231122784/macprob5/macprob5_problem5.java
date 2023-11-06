package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob5_problem5 {
    public static void main(String[] args) {
        
        // Initialize Die class variable
        Die d6_player = new Die(6);
        Die d6_computer = new Die(6);

        // Initialize value holder variables
        int score_player = 0;
        int score_computer = 0;
        int round_counter = 1;
        boolean willPlayerRoll = false;
        boolean isInputValid = false;
        char user_input;

        do {
            // Print round number
            print.ln("Round " + round_counter);

            // Ask input if player will roll
            do {
                print.s("Roll the die (y/n)? ");
                try {
                    user_input = input.schar();
                    if (user_input == 'y') {
                        isInputValid = true;
                        willPlayerRoll = true;
                    }
                    else if (user_input == 'n') {
                        isInputValid = true;
                        willPlayerRoll = false;
                    }
                    else {
                        isInputValid = false;
                        continue;
                    }
                } catch (Exception e) {
                    print.ln("(!) ERROR: Invalid input");
                    continue;
                }
            } while (!isInputValid);

            print.ln("--- --- --- --- ---");
            
        } while (willPlayerRoll);
        
    }
}
