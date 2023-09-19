package com.uecpe20231122784.macprob4;

import java.util.Scanner;
import com.uecpe20231122784.macprob4.lib.out;

public class macprob4_problem1 {

    public static void main() {
        
        // Program title
        out.println("Character Finder");

        // Declare initial variables/resources
        Scanner stdin = new Scanner(System.in);

        // Get user input
        out.print("Text to process: ");
        String text = stdin.nextLine();
        out.print("Character index to find: ");
        int position = stdin.nextInt();

        // Invoke method
        showChar(text, position);

        // Close resources
        stdin.close();
    }

    public static void showChar(String string, int index) {
        out.println(string.charAt(index));
    }

}
