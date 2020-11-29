package com.webgamers.worldconquer.game.model;

import com.webgamers.worldconquer.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class GameAndUser {
    @Id
    @Column(name = "game_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    private Integer score;

    @Builder
    public GameAndUser(Long id, User user, Game game, Integer score) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.score = score;
    }
}
