package com.webgamers.worldconquer.post.controller;

import com.webgamers.worldconquer.post.dto.CommentRegisterRequestDto;
import com.webgamers.worldconquer.post.dto.PostRegisterRequestDto;
import com.webgamers.worldconquer.post.mapper.PostResponseMapper;
import com.webgamers.worldconquer.post.service.PostService;
import com.webgamers.worldconquer.user.security.AuthUser;
import com.webgamers.worldconquer.user.security.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("registration/post")
    public ResponseEntity<Long> registerPost(@Authentication AuthUser authUser,
                                             @RequestBody PostRegisterRequestDto payload) {
        return ResponseEntity
                .status(201)
                .body(postService.registerPost(authUser, payload));
    }

    @PostMapping("registration/comment")
    public ResponseEntity<Long> registerComment(@Authentication AuthUser authUser,
                                             @RequestBody CommentRegisterRequestDto payload) {
        return ResponseEntity
                .status(201)
                .body(postService.registerComment(authUser, payload));
    }

    @GetMapping("posts")
    public List<PostResponseMapper> findAllPost(@Authentication AuthUser authUser) {
        return postService.findAllPost();
    }

    @GetMapping("post/{id}")
    public PostResponseMapper findPostByUd(@Authentication AuthUser authUser,
                                           @PathVariable("id") final Long id) {
        return postService.findPostById(authUser, id);
    }
}
