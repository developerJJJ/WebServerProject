package com.webgamers.worldconquer.game.model;

import com.webgamers.worldconquer.shared.BaseTimeEntity;
import com.webgamers.worldconquer.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class GameHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Builder
    public GameHistory(Long id, User user, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
    }
}
