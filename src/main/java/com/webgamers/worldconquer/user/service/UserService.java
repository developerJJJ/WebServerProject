package com.webgamers.worldconquer.user.service;


import com.webgamers.worldconquer.user.model.User;
import com.webgamers.worldconquer.user.repository.UserRepository;
import com.webgamers.worldconquer.user.security.payload.UsernameValidationResponse;
import com.webgamers.worldconquer.user.security.payload.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Long registerUser(final SignUpRequest payload) {
        return userRepository.save(User.builder()
                .username(payload.getUsername())
                .password(passwordEncoder.encode(payload.getPassword()))
                .build()).getId();
    }

    @Transactional
    public UsernameValidationResponse existUserCheck(String email) {
        final String message = userRepository.existsByUsername(email)
                ? "아이디가 사용중입니다!"
                : "사용가능한 아이디입니다!";

        return new UsernameValidationResponse(message);
    }
}
