package com.cboard.marketplace.marketplace_common.dto;

public class AuthResponse {
    private String token;

    // default constructor
    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}