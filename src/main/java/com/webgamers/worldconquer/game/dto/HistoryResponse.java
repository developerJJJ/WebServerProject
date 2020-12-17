package com.webgamers.worldconquer.game.dto;

import com.webgamers.worldconquer.game.model.GameHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class HistoryResponse {
    private Long id;
    private String username;
    private LocalDateTime createdAt;


    @Builder
    public HistoryResponse(Long id, String username, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

    public static HistoryResponse of(final GameHistory gameHistory) {
        return HistoryResponse
                .builder()
                .id(gameHistory.getId())
                .username(gameHistory.getUser().getUsername())
                .createdAt(gameHistory.getCreatedAt())
                .build();
    }
}
