package com.uecpe20231122784.macprob5;

public class Employee {

    private static int counter;

    private String name;
    private int idNumber;
    private String department;
    private String position;

    public Employee() {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
        counter++;
    }

    public Employee(String e_name, int e_idNumber, String e_department, String e_position) {
        name = e_name;
        idNumber = e_idNumber;
        department = e_department;
        position = e_position;
        counter++;
    }

    public Employee(String e_name, int e_idNumber) {
        name = e_name;
        idNumber = e_idNumber;
        department = "";
        position = "";
        counter++;
    }
    
    public void setName(String e_name) {
        name = e_name;
    }

    public void setID(int e_idNumber) {
        idNumber = e_idNumber;
    }

    public void setDepartment(String e_department) {
        department = e_department;
    }

    public void setPosition(String e_position) {
        position = e_position;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return idNumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public static int getInstanceCount() {
        return counter;
    }

}
