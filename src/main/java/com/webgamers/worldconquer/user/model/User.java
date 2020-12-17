package com.webgamers.worldconquer.user.model;

import com.webgamers.worldconquer.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String password;

    @Builder
    public User(Long id,  String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
