package com.uecpe20231122784.lib;

import java.util.Scanner;

public class cli {

    public static Scanner s = new Scanner(System.in);
    
    public static Object waitForInput(String type) {
        String i = s.nextLine();
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