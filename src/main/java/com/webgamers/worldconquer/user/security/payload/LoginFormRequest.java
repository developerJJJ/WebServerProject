package com.webgamers.worldconquer.user.security.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class LoginFormRequest {
    private String username;
    private String password;

    public LoginFormRequest(@Email String username, String password) {
        this.username = username;
        this.password = password;
    }
}