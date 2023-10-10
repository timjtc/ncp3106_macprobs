package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.print;

public class macprob5_problem2 {

    public static void main(String[] args) {
        
        // Instantiate instances of personal data
        PersonalInfo pii_1 = new PersonalInfo(
            "Timothy James Concepcion", 
            "Brgy Kaypian, San Jose del Monte, Bulacan 3023", 
            22, 
            "+639760421984"
        );
        PersonalInfo pii_2 = new PersonalInfo(
            "Luzviminda Concepcion",
            "Brgy Kaypian, San Jose del Monte, Bulacan 3023",
            67,
            "+639760421985"
        );
        PersonalInfo pii_3 = new PersonalInfo();

        // Test set methods
        pii_3.setName("Mark Ryan Concepcion");
        pii_3.setAddress("Brgy Kaypian, San Jose del Monte, Bulacan 3023");
        pii_3.setAge(36);
        pii_3.setPhoneNum("+639296612175");

        // Consolidate all PII objects
        PersonalInfo[] pii_array = {pii_1, pii_2, pii_3};

        // get methods through a foreach loop
        for (PersonalInfo pii : pii_array) {
            print.ln("Name: " + pii.getName());
            print.ln("Address: " + pii.getAddress());
            print.ln("Age: " + pii.getAge());
            print.ln("Phone Number: " + pii.getPhoneNum());
            print.ln("--- --- --- --- ---");
        }

    }

}
