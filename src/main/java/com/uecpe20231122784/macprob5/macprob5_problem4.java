package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.print;

public class macprob5_problem4 {
    public static void main(String[] args) {
        
        // Set constant number of times to toss the coin
        final int TOSS_ITERATIION = 20;
        
        // Instantiate new coin and tell the side facing up
        Coin coin = new Coin();
        print.ln("Side facing up: " + coin.getSideUp());

        // Loop through tossing the coin many times
        for (int i = 0; i < TOSS_ITERATIION; i++) {
            coin.toss();
            print.ln("Toss#" + (i + 1) + ": " + coin.getSideUp());
        }
        
        // Print toss summary
        print.ln("--- --- --- --- ---");
        print.ln("Number of times heads occured: " + coin.getHeadsOccurence());
        print.ln("Number of times tails occured: " + coin.getTailsOccurence());
        
    }
}
