package com.uecpe20231122784.macprob5;

import java.util.Random;

public class Coin {
    
    private String sideUp;
    private int rand_int;
    private static Random rand = new Random();
    private int heads_occurence = 0;
    private int tails_occurence = 0;

    public Coin() {
        rand_int = rand.nextInt(2) + 1;
        // rand_int = (int) (Math.random() * 2);
        if (rand_int == 1) {
            sideUp = "heads";
        }
        else {
            sideUp = "tails";
        }
    }

    public void toss() {
        rand_int = rand.nextInt(2) + 1;
        // rand_int = (int) (Math.random() * 2);
        if (rand_int == 1) {
            sideUp = "heads";
            heads_occurence++;
        }
        else {
            sideUp = "tails";
            tails_occurence++;
        }
    }

    public int getRandInt() {
        return rand_int;
    }

    public String getSideUp() {
        return sideUp;
    }

    public int getTailsOccurence() {
        return tails_occurence;
    }

    public int getHeadsOccurence() {
        return heads_occurence;
    }

}
