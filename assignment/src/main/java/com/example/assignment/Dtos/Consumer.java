package com.example.assignment.Dtos;

public class Consumer {

    private String givenNames;
    private String surname;
    private String email;

    public Consumer() {
    }

    public Consumer(String givenNames, String surname, String email) {
        this.givenNames = givenNames;
        this.surname = surname;
        this.email = email;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
