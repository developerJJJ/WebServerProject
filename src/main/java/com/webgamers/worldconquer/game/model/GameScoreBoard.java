package com.webgamers.worldconquer.game.model;

import com.webgamers.worldconquer.shared.BaseTimeEntity;
import com.webgamers.worldconquer.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class GameScoreBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer areaNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer score;

    @Builder
    public GameScoreBoard(Long id, Integer areaNumber, User user, Integer score) {
        this.id = id;
        this.areaNumber = areaNumber;
        this.user = user;
        this.score = score;
    }

    public GameScoreBoard update(Integer point) {
        if (this.score < point)
            this.score = point;
        return this;
    }
}
