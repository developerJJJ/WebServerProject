package com.webgamers.worldconquer.game.repository;

import com.webgamers.worldconquer.game.model.GameScoreBoard;
import com.webgamers.worldconquer.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameScoreBoardRepository extends JpaRepository<GameScoreBoard, Long> {
    boolean existsByUserAndAreaNumber(User user, Integer areaNumber);
    List<GameScoreBoard> findAllByAreaNumberOrderByScoreDesc(final Integer areaNumber);
    Optional<GameScoreBoard> findByAreaNumberAndUser(Integer areaNumber,User user);
}
