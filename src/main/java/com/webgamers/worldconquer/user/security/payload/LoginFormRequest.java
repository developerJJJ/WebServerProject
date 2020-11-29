package com.webgamers.worldconquer.user.security.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
public class LoginFormRequest {
    @Email
    private String email;
    private String password;

    public LoginFormRequest(@Email String email, String password) {
        this.email = email;
        this.password = password;
    }
}