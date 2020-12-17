package com.webgamers.worldconquer.user.security.payload;

public class UsernameValidationResponse {
    private String message;

    public UsernameValidationResponse() {}
    public UsernameValidationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
