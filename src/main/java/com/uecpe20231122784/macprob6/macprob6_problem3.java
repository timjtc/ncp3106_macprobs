package com.uecpe20231122784.macprob6;

import java.util.Arrays;
import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob6_problem3 {
    
    public static void main(String[] args) {
            
            // Create LottoDraw instance
            LottoDraw lotto = new LottoDraw();
    
            // Get user's pick
            int[] pick = new int[5];
            for (int i = 0; i < pick.length; i++) {
                print.s("Enter pick #" + (i + 1) + ": ");
                try {
                    pick[i] = (int) input.wait("int");
                } catch (Exception e) {
                    print.ln("(!) ERROR: Invalid input, please try again.");
                    i--;
                }
            }
    
            // Print lotto results
            print.ln(
                "----------------------------------------\n" +
                "Lotto results:"
            );
            print.ln(" Drawn numbers: " + Arrays.toString(lotto.getDrawnNumbers()).replace("[", "").replace("]", ""));
            print.ln(" Your pick: " + Arrays.toString(pick).replace("[", "").replace("]", ""));
            print.ln(" Matched numbers: " + lotto.comparePick(pick).toString().replace("[", "").replace("]", "").replace("[]", ""));
            if (lotto.comparePick(pick).size() == 5) {
                print.ln(" You are the grand prize winner for the lotto!");
            }
    }

}
