package com.webgamers.worldconquer.user.security.payload;

public class EmailValidationResponse {
    private String message;

    public EmailValidationResponse() {}
    public EmailValidationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
