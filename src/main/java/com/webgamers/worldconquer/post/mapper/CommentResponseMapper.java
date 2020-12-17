package com.webgamers.worldconquer.post.mapper;

import com.webgamers.worldconquer.post.model.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseMapper {
    private Long id;
    private String title;
    private String comment;
    private String writer;
    private String date;

    @Builder
    public CommentResponseMapper(Long id,
                                 String title,
                                 String comment,
                                 String writer,
                                 String date) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.writer = writer;
        this.date = date;
    }

    public static CommentResponseMapper of(final Comment comment) {
        return CommentResponseMapper.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .date(comment.getCreatedAt().toString())
                .writer(comment.getUser().getUsername())
                .build();
    }
}
