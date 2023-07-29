package com.example.assignment.Dtos;

public class OrderResponse {
    private String token;
    private String expires;
    private String checkoutUrl;

    public OrderResponse() {
    }

    public OrderResponse(String token, String expires, String checkoutUrl) {
        this.token = token;
        this.expires = expires;
        this.checkoutUrl = checkoutUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

}
