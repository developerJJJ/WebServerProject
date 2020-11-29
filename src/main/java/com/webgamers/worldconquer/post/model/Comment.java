package com.webgamers.worldconquer.post.model;

import com.webgamers.worldconquer.shared.BaseTimeEntity;
import com.webgamers.worldconquer.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String comment;

    @Builder
    public Comment(Long id, User user, Post post, String comment) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.comment = comment;
    }
}
