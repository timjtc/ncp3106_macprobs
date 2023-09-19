package com.uecpe20231122784.macprob4;

import com.uecpe20231122784.macprob4.lib.out;
import com.uecpe20231122784.macprob4.lib.cli;

public class macprob4_problem4 {
    public static void main() {
        // Print program desc/title
        out.println("Length Unit Converter");

        // Declare initial vars
        boolean loop_again;
        double length = 0.0;
        int option = 0;

        do {
            try {
                // Get length value
                out.print("Enter a length in meters: ");
                length = (double) cli.waitForInput("double");

                // Display menu and get option form user input
                menu();                
                option = (int) cli.waitForInput("int");

                // Validate user input if within bounds
                if (option < 1 || option > 4) {
                    out.println("<!> ERROR: Invalid input");
                    loop_again = true;
                    continue;
                }

                // Invoke appropriate method based on option selected
                switch (option) {
                case 1:
                    showKilometers(length);
                    break;
                case 2:
                    showInches(length);
                    break;
                case 3:
                    showFeet(length);
                case 4:
                    System.exit(50);
                default:
                    out.println("<!> ERROR: Invalid input");
                    break;
                }
                loop_again = false;
                
            } catch (Exception e) {
                // Catch invalid data types/casting
                out.println("<!> ERROR: Invalid input");
                loop_again = true;
            }
        } while (loop_again);
    }

    public static void menu() {
        out.print("Choose an option: " + 
                "\n (1) convert to kilometers" +
                "\n (2) convert to inches" +
                "\n (3) convert to feet" +
                "\n (4) quit program" +
                "\n>> ");
    }

    public static void showKilometers(double length) {
        out.println("=" + length * 0.001 + " km");
    }

    public static void showInches(double length) {
        out.println("=" + length * 39.37 + " in");
    }

    public static void showFeet(double length) {
        out.println("=" + length * 3.281 + " ft");
    }

}
