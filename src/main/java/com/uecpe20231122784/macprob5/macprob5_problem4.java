package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.print;

public class macprob5_problem4 {
    public static void main(String[] args) {
        
        final int TOSS_ITERATIION = 20;
        
        Coin c = new Coin();
        print.ln("Side facing up: " + c.getSideUp());

        for (int i = 0; i < TOSS_ITERATIION; i++) {
            print.ln("Toss#" + i + ": " + c.getSideUp());
        }                
    }
}
