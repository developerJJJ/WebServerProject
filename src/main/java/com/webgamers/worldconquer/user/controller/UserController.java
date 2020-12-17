package com.webgamers.worldconquer.user.controller;

import com.webgamers.worldconquer.user.model.User;
import com.webgamers.worldconquer.user.repository.UserRepository;
import com.webgamers.worldconquer.user.security.AuthUser;
import com.webgamers.worldconquer.user.security.Authentication;
import com.webgamers.worldconquer.user.security.exception.ResourceNotFoundException;
import com.webgamers.worldconquer.user.security.payload.UsernameValidationResponse;
import com.webgamers.worldconquer.user.security.payload.SignUpRequest;
import com.webgamers.worldconquer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("greeting/{name}")
    public String greeting(@PathVariable("name") final String name) {
        return "hello " + name;
    }

    @PostMapping(value = "registration", consumes = "application/json")
    public ResponseEntity<Long> registerUser(@RequestBody final SignUpRequest payload) {
        log.info("email {}", payload.getUsername());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.registerUser(payload));
    }

    @GetMapping("validation")
    public UsernameValidationResponse existUserCheck(@RequestParam("email") final String email) {
        return userService.existUserCheck(email);
    }

    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@Authentication final AuthUser authUser) {
        return userRepository.findById(authUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", authUser.getId()));
    }
}