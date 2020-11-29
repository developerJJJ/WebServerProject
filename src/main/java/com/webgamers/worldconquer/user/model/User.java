package com.webgamers.worldconquer.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webgamers.worldconquer.shared.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    @Builder
    public User(Long id, @Email String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
