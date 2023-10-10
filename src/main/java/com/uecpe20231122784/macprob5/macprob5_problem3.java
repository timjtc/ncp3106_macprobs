package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob5_problem3 {
    
    public static void main(String[] args) {
        
        // Get user input
        print.p("Number of scores: ");
        TestScores ts = new TestScores((int) input.wait("int"));

        // Get input scores based on defined size
        for(int i = 0; i < ts.getSize(); i++) {
            print.p("Input score#" + (i + 1) + ": ");
            ts.setScore(i, (double) input.wait("double"));
        }

        // Print average of scores
        print.ln("Average: " + ts.computeAverage());

    }

}
