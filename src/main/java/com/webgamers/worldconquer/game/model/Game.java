package com.webgamers.worldconquer.game.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @Column(name = "game_id")
    private Long id;
    private String name;

    @Builder
    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
