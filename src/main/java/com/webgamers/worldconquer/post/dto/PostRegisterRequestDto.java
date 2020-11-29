package com.webgamers.worldconquer.post.dto;

import com.webgamers.worldconquer.post.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRegisterRequestDto {
    private String title;
    private String content;

    @Builder
    public PostRegisterRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post toPostEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
