package com.uecpe20231122784.macprob5;

import java.util.Random;

public class Coin {
    
    private String sideUp;
    private int rand_int;
    private Random rand = new Random();

    public Coin() {
        toss();
    }

    public void toss() {
        rand_int = rand.nextInt(2) + 1;
        if (rand_int == 0) {
            sideUp = "heads";
        }
        else {
            sideUp = "tails";
        }
    }

    public int getRandInt() {
        return rand_int;
    }

    public String getSideUp() {
        return sideUp;
    }

}
