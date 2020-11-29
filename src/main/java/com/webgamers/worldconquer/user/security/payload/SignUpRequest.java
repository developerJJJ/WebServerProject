package com.webgamers.worldconquer.user.security.payload;

import com.webgamers.worldconquer.user.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    private String email;
    private String password;

    public SignUpRequest(@Email @NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }

    public User toUserEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
