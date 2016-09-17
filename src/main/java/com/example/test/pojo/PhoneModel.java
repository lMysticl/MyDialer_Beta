package com.example.test.pojo;


public class PhoneModel {
    private String firstName;
    private String secondName;

    public PhoneModel(String fistName, String secondName) {
        this.secondName = secondName;
        this.firstName = fistName;

    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
