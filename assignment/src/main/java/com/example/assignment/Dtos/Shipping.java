package com.example.assignment.Dtos;

public class Shipping {
    private String phoneNumber;
    private String countryCode;
    private String name;
    private String postCode;
    private String suburb;
    private String line1;

    public Shipping(String phoneNumber, String countryCode, String name, String postCode, String suburb, String line1) {
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.name = name;
        this.postCode = postCode;
        this.suburb = suburb;
        this.line1 = line1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

}
