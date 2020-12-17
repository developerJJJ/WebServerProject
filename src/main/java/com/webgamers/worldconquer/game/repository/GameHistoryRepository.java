package com.webgamers.worldconquer.game.repository;

import com.webgamers.worldconquer.game.model.GameHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameHistoryRepository extends JpaRepository<GameHistory, Long> {
    @Query(value = "select g from GameHistory g order by g.createdAt desc")
    List<GameHistory> findAllOrderByCreatedAtDesc();
}
