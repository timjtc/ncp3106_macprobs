package com.uecpe20231122784.macprob5;

import java.util.Arrays;

public class TestScores {
    
    private double[] score_array;
    // int size;

    public TestScores(int n) {
       score_array = new double[n];
    //    size = n;
    }

    public void setScore(int n, double score) {
        score_array[n] = score;
    }

    public String dump() {
        return Arrays.toString(score_array);
    }

    public double getScore(int n) {
        return score_array[n];
    }

    public int getSize() {
        return score_array.length;
    }

    public double[] getArrayObj() {
        return score_array;
    }

    public double computeAverage() {
        double total = 0;
        for (double d : score_array) {
            total = total + d;
        }
        return total / score_array.length;
    }

}
