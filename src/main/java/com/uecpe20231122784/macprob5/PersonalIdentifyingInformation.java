package com.uecpe20231122784.macprob5;

public class PersonalIdentifyingInformation {
    
    private static int counter;

    private String name;
    private String address;
    private int age;
    private String phone_number;

    public PersonalIdentifyingInformation(String pii_name, String pii_address, int pii_age, String pii_phone_number) {
        name = pii_name;
        address = pii_address;
        age = pii_age;
        phone_number = pii_phone_number;
        counter++;
    }

    public PersonalIdentifyingInformation() {
        name = "";
        address = "";
        age = 0;
        phone_number = "";
        counter++;
    }

    public void setName(String pii_name) {
        name = pii_name;
    }

    public void setAddress(String pii_address) {
        address = pii_address;
    }

    public void setAge(int pii_age) {
        age = pii_age;
    }

    public void setPhoneNum(String pii_phone_number) {
        phone_number = pii_phone_number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phone_number;
    }

}
