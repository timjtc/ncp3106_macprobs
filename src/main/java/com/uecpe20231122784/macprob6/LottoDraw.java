package com.uecpe20231122784.macprob6;

import java.util.ArrayList;
import java.util.Random;

public class LottoDraw {
    
    private static Random rand = new Random();
    
    int[] drawn_numbers = new int[5];

    public LottoDraw() {
        for (int i = 0; i < 5; i++) {
            drawn_numbers[i] = intByRange(0, 9);
        }
    }

    public ArrayList<Integer> comparePick(int[] pick_numbers) {
        ArrayList<Integer> matched_numbers = new ArrayList<Integer>();
        for (int i = 0; i < drawn_numbers.length; i++) {
            if (drawn_numbers[i] == pick_numbers[i]) {
                matched_numbers.add(pick_numbers[i]);
            }
        }
        return matched_numbers;
    }

    public int[] getDrawnNumbers() {
        return drawn_numbers;
    }

    private static int intByRange(int min, int max) {
        int num = rand.nextInt((max - min) + 1) + min;
        return num;
    }

}
