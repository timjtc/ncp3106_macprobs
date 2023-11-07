package com.uecpe20231122784.macprob6;

import java.util.Arrays;
import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob6_problem4 {
    
    public static void main(String[] args) {

        // Initialize 3x3 matrix
        int[][] matrix = new int[3][3];
        // Ask for values to fill 3x3 matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Print matrix every iteration to show progress
                printIntMatrix(matrix);
                print.s("Enter number for row " + (i + 1) + ", column " + (j + 1) + ": ");
                matrix[i][j] = (int) input.wait("int");
                print.ln("----------------------------------------");
            }
        }

        // Check if matrix is a valid Lo Shu Square
        if (checkLoShuValidity(matrix)) {
            print.ln("The matrix is a valid Lo Shu Square.");
        }
        else {
            print.ln("The matrix is not a valid Lo Shu Square.");
        }
    }

    public static boolean checkLoShuValidity(int[][] matrix) {
        // Check if matrix is a square
        if (matrix.length != matrix[0].length) {
            return false;
        }

        // Check if matrix contains all numbers 1-9
        int[] numbers = new int[9];
        for (int[] row : matrix) {
            for (int number : row) {
                if (number < 1 || number > 9) {
                    return false;
                }
                numbers[number - 1]++;
            }
        }
        for (int number : numbers) {
            if (number != 1) {
                return false;
            }
        }

        // Check if all rows, columns, and diagonals add up to 15
        int[] rowSums = new int[3];
        int[] colSums = new int[3];
        int[] diagSums = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            rowSums[0] += matrix[0][i];
            rowSums[1] += matrix[1][i];
            rowSums[2] += matrix[2][i];
            colSums[0] += matrix[i][0];
            colSums[1] += matrix[i][1];
            colSums[2] += matrix[i][2];
            diagSums[0] += matrix[i][i];
            diagSums[1] += matrix[i][matrix.length - i - 1];
        }
        for (int i = 0; i < rowSums.length; i++) {
            if (rowSums[i] != 15 || colSums[i] != 15) {
                return false;
            }
        }
        for (int i = 0; i < diagSums.length; i++) {
            if (diagSums[i] != 15) {
                return false;
            }
        }

        return true;
    }

    public static void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            print.ln(Arrays.toString(row)
                .replace("[", "| ")
                .replace("]", " |")
                .replace(",", " ")
                .replace("0", "_")
            );
        }
    }

}
