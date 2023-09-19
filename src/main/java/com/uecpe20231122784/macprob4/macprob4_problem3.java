package com.uecpe20231122784.macprob4;

import com.uecpe20231122784.macprob4.lib.out;
import com.uecpe20231122784.macprob4.lib.cli;

public class macprob4_problem3 {
    public static void main() {
        
        // Print program desc/title
        out.println("Share Profit Calculator");

        // Declare initial vars
        boolean loop_again;
        double ns = 0.0, sp = 0.0, sc = 0.0, pp = 0.0, pc = 0.0;

        // Get user input with validation/handling
        do {
            try {
                out.print("Number of shares: ");
                ns = (double) cli.waitForInput("double");
                out.print("Sale price per share: ");
                sp = (double) cli.waitForInput("double");
                out.print("Sale commission paid: ");
                sc = (double) cli.waitForInput("double");
                out.print("Purchase price per share: ");
                pp = (double) cli.waitForInput("double");
                out.print("Purchase commission paid: ");
                pc = (double) cli.waitForInput("double");
                loop_again = false;
            } catch (Exception e) {
                out.println("<!> ERROR: Invalid input");
                loop_again = true;
            }
        } while (loop_again);
        
        // Invoke method and print result
        out.println("=== === === ===");
        out.println("Profit: " + calculateProfit(ns, pp, pc, sp, sc));
    }

    public static double calculateProfit(double shares, double purchase_share, double purchase_commission, double sale_share, double sale_commission) {
        return ((shares * sale_share) - sale_commission) - ((shares * purchase_share) + purchase_commission);
    }
}
