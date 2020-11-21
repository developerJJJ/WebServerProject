package com.webgamers.worldconquer.auth.controller;

import com.webgamers.worldconquer.auth.model.User;
import com.webgamers.worldconquer.auth.repository.UserRepository;
import com.webgamers.worldconquer.auth.security.AuthUser;
import com.webgamers.worldconquer.auth.security.Authentication;
import com.webgamers.worldconquer.auth.security.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("greeting/{name}")
    public String greeting(@PathVariable("name") final String name) {
        return "hello " + name;
    }

    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@Authentication final AuthUser authUser) {
        return userRepository.findById(authUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", authUser.getId()));
    }
}