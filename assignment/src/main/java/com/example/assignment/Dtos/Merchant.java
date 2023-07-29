package com.example.assignment.Dtos;

public class Merchant {
    private String redirectCancelUrl;
    private String redirectConfirmUrl;

    public Merchant(String redirectCancelUrl, String redirectConfirmUrl) {
        this.redirectCancelUrl = redirectCancelUrl;
        this.redirectConfirmUrl = redirectConfirmUrl;
    }

    public String getRedirectCancelUrl() {
        return redirectCancelUrl;
    }

    public void setRedirectCancelUrl(String redirectCancelUrl) {
        this.redirectCancelUrl = redirectCancelUrl;
    }

    public String getRedirectConfirmUrl() {
        return redirectConfirmUrl;
    }

    public void setRedirectConfirmUrl(String redirectConfirmUrl) {
        this.redirectConfirmUrl = redirectConfirmUrl;
    }

}
