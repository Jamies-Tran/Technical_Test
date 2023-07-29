package com.example.assignment.Dtos;

public class Consumer {
    private String givenName;
    private String surname;
    private String email;

    public Consumer(String givenName, String surname, String email) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
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
