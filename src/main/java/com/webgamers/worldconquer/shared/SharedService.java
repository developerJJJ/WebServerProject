package com.webgamers.worldconquer.shared;

import com.webgamers.worldconquer.user.model.User;
import com.webgamers.worldconquer.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SharedService {
    private final UserRepository userRepository;

    public User getUser(final Long id)  {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

}
