package com.uecpe20231122784.macprob6;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

import com.uecpe20231122784.macprob6.RainLevel;

public class macprob6_problem1 {
    
    public static void main(String[] args) {

        // Create RainLevel instance
        RainLevel rainfall_data = new RainLevel();

        // Get rainfall data from user
        for (int i = 0; i < 12; i++) {

            print.s("Enter rainfall for " + numberToMonth(i + 1) + ": ");
            try {
                rainfall_data.setRainfallForMonth(i + 1, (double) input.wait("double"));
            } catch (Exception e) {
                print.ln("(!) ERROR: Invalid input, please try again.");
                i--;
            }

        }
        
        // Print rainfall compuations with given data
        print.ln(
            "----------------------------------------\n" +
            "Rainfall computations with given data:"
        );
        print.ln(" Total rainfall: " + rainfall_data.getTotalRainfall());
        print.ln(" Average rainfall: " + rainfall_data.getAverageRainfall());
        Object[] highest = rainfall_data.getHighestRainfall();
        print.ln(" Highest rainfall: " + highest[1] + " in " + numberToMonth((int) highest[0]));
        Object[] lowest = rainfall_data.getLowestRainfall();
        print.ln(" Lowest rainfall: " + lowest[1] + " in " + numberToMonth((int) lowest[0]));

    }

    public static String numberToMonth(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "Febuary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "Septemeber";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: throw new IllegalArgumentException("Month must be between 1 and 12");
        }
    }

}
