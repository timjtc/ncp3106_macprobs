package com.uecpe20231122784.macprob5;

import com.uecpe20231122784.lib.print;

public class macprob5_problem1 {
    public static void main(String[] args) {
        
        // Instantiate instances of employees
        Employee employee_Rubio_11293 = new Employee("Alexis John Rubio", 11293, "CpE", "Faculty");
        Employee employee_Lazaro_06208 = new Employee("Joan Lazaro", 6208, "Engineering", "President");
        Employee employee_Sim_05752 = new Employee("Paraluman Sim", 5752);

        // Mutator methods test
        employee_Sim_05752.setDepartment("R and D");
        employee_Sim_05752.setPosition("Manager");

        // Consolidate all employee objects
        Employee[] employees_array = {employee_Rubio_11293, employee_Lazaro_06208, employee_Sim_05752};

        // Accessor methods through a foreach loop
        for (Employee e : employees_array) {
            print.ln("ID Number: " + String.format("%05d", e.getID()));
            print.ln("Name: " + e.getName());
            print.ln("Department: " + e.getDepartment());
            print.ln("Position: " + e.getPosition());
            print.ln("--- --- --- --- ---");
        }

    }
}
