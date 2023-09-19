package com.uecpe20231122784.macprob4.lib;

public class out {
    
    public static <PrintableToString> void println(PrintableToString... args) {
        for (PrintableToString pts : args) {
            System.out.print(pts);
        }
        System.out.println();
    }

    public static <PrintableToString> void print(PrintableToString... args) {
        for(PrintableToString pts: args) {
            System.out.print(pts);
        }
            
    }

    public static <PrintableToString> void printf(String format, PrintableToString... args) {
        System.out.println(String.format(format, args));
    }
    
}