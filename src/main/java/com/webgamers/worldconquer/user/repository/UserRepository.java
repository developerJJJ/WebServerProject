package com.webgamers.worldconquer.user.repository;

import com.webgamers.worldconquer.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(final String username);
    Optional<User> findById(final Long id);
    Boolean existsByUsername(final String username);
}
