package com.uecpe20231122784.macprob6;

import java.util.ArrayList;

import com.uecpe20231122784.lib.input;
import com.uecpe20231122784.lib.print;

public class macprob6_problem5 {
    
    private static ArrayList<String> valid_acc_nums = new ArrayList<String>() 
    {{
        add("5658845");
        add("4520125");
        add("7895122");
        add("8777541");
        add("8451277");
        add("1302850");
        add("8080152");
        add("4562555");
        add("5552012");
        add("5050552");
        add("7825877");
        add("1250255");
        add("1005231");
        add("6545231");
        add("3852085");
        add("7576651");
        add("7881200");
        add("4581002");
    }};

    public static void main(String[] args) {

        print.s("Enter an account number: ");
        if (checkAccountValidity((String) input.wait("string"))) {
            print.ln("The account number is valid.");
        }
        else {
            print.ln("The account number is invalid.");
        }
    }

    public static boolean checkAccountValidity(String acc_num) {

        for (String valid_acc_num : valid_acc_nums) {
            if (acc_num.equals(valid_acc_num)) {
                return true;
            }
        }
        return false;

    }

}
