package com.uecpe20231122784.macprob4;

import java.util.Scanner;
// import com.uecpe20231122784.lib.sysoutalias.*;

public class macprob4_problem1 {

    public static void main() {
        
        // Program title
        System.out.println("Character Picker");

        // Declare initial variables/resources
        Scanner stdin = new Scanner(System.in);

        // Get user input
        System.out.print("Text to process: ");
        String text = stdin.nextLine();
        System.out.print("Character index to find: ");
        int position = stdin.nextInt();

        // Invoke method
        showChar(text, position);
    }

    public static void showChar(String string, int index) {
        System.out.println(string.charAt(index));
    }

}
