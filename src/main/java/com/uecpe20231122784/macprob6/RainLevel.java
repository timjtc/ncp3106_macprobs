package com.uecpe20231122784.macprob6;

public class RainLevel {
    
    private double[] rainfall_data;

    public RainLevel() {
        rainfall_data = new double[12];
    }

    public RainLevel(double[] rainfall_data) {

        if (rainfall_data.length < 13) {

            for (double d : rainfall_data) {
                if (d < 0) {
                    throw new IllegalArgumentException("Rainfall data cannot be negative");
                }
            }
            this.rainfall_data = rainfall_data;
        }
        else {
            throw new IllegalArgumentException("Rainfall data cannot be more than 12 months");
        }
        
    }

    public double getTotalRainfall() {
        double total = 0.0;
        for (double d : rainfall_data) {
            total += d;
        }
        return total;
    }

    public double getAverageRainfall() {
        return getTotalRainfall() / rainfall_data.length;
    }

    public double getRainfallForMonth(int month) {
        return rainfall_data[month - 1];
    }

    public void setRainfallForMonth(int month, double rainfall) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        else if (rainfall < 0) {
            throw new IllegalArgumentException("Rainfall occurence cannot be negative");
        }
        else {
            rainfall_data[month - 1] = rainfall;
        }
    }

    /*
     * Returns an array of length 2, where the first element is the month number of the highest rainfall
     * and the second element is the value of the highest rainfall
     */
    public Object[] getHighestRainfall() {
        Object[] highest = {0, rainfall_data[0]};
        for (int i = 0; i < rainfall_data.length; i++) {
            if (rainfall_data[i] > (double) highest[1]) {
                highest[0] = i;
                highest[1] = rainfall_data[i];
            }
        }
        highest[0] = ((int) highest[0]) + 1; // add 1 to the index to show month number
        return highest;
    }

    /*
     * Returns an array of length 2, where the first element is the month number of the lowest rainfall
     * and the second element is the value of the lowest rainfall
     */
    public Object[] getLowestRainfall() {
        Object[] lowest = {0, rainfall_data[0]};
        for (int i = 0; i < rainfall_data.length; i++) {
            if (rainfall_data[i] < (double) lowest[1]) {
                lowest[0] = i;
                lowest[1] = rainfall_data[i];
            }
        }
        lowest[0] = ((int) lowest[0]) + 1; // add 1 to the index to show month number
        return lowest;
    }

}
