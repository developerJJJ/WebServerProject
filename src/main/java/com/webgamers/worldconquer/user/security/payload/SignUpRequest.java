package com.webgamers.worldconquer.user.security.payload;

import com.webgamers.worldconquer.user.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;

    public SignUpRequest(@Email @NotNull String username, @NotNull String password) {
        this.username = username;
        this.password = password;
    }

    public User toUserEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
