package com.uecpe20231122784.macprob4.lib;

import java.util.Random;

public class rand {
    
    public static int randInt(Random r, int min, int max) {
        int rand = r.nextInt((max - min) + 1) + min;
        return rand;
    }
    
}


