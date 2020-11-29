package com.webgamers.worldconquer.post.dto;

import com.webgamers.worldconquer.post.model.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRegisterRequestDto {
    private Long postId;
    private String comment;

    @Builder
    public CommentRegisterRequestDto(Long postId, String comment) {
        this.postId = postId;
        this.comment = comment;
    }

    public Comment toCommentEntity() {
        return Comment.builder()
                .comment(comment)
                .build();
    }
}
