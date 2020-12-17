package com.webgamers.worldconquer.post.mapper;

import com.webgamers.worldconquer.post.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostResponseMapper {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String date;
    private List<CommentResponseMapper> comments;

    @Builder
    public PostResponseMapper(Long id,
                              String title,
                              String content,
                              String writer,
                              String date,
                              List<CommentResponseMapper> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
        this.comments = comments;
    }

    public static PostResponseMapper of(final Post post) {
        return PostResponseMapper.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getCreatedAt().toString().split("T")[0])
                .writer(post.getUser().getUsername())
                .comments(post.getComments()
                        .stream()
                        .map(CommentResponseMapper::of)
                        .collect(Collectors.toList()))
                .build();
    }

}
