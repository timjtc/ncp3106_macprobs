package com.uecpe20231122784.macprob4.lib;

import java.util.Scanner;

public class stdin_interface {
    
    public static Object waitForInput(Scanner scanner, String type) {
        String i = scanner.nextLine();
        switch (type) {
            case "int":
                return Integer.parseInt(i);
            case "double":
                return Double.parseDouble(i);
            case "float":
                return Float.parseFloat(i);
            case "boolean":
                return Boolean.parseBoolean(i);
            default:
                return i;
        }
    }

}