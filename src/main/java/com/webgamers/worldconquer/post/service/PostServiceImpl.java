package com.webgamers.worldconquer.post.service;

import com.webgamers.worldconquer.post.dto.CommentRegisterRequestDto;
import com.webgamers.worldconquer.post.dto.PostRegisterRequestDto;
import com.webgamers.worldconquer.post.mapper.PostResponseMapper;
import com.webgamers.worldconquer.post.model.Comment;
import com.webgamers.worldconquer.post.model.Post;
import com.webgamers.worldconquer.post.repository.CommentRepository;
import com.webgamers.worldconquer.post.repository.PostRepository;
import com.webgamers.worldconquer.user.model.User;
import com.webgamers.worldconquer.user.repository.UserRepository;
import com.webgamers.worldconquer.user.security.AuthUser;
import com.webgamers.worldconquer.user.security.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    @Override
    @Transactional
    public Long registerPost(AuthUser authUser, PostRegisterRequestDto payload) {
        return postRepository.save(Post.builder()
                .title(payload.getTitle())
                .content(payload.getContent())
                .user(getUser(authUser.getId()))
                .build()).getId();
    }

    @Override
    @Transactional
    public Long registerComment(AuthUser authUser, CommentRegisterRequestDto payload) {
        return commentRepository.save(Comment.builder()
                .comment(payload.getComment())
                .user(getUser(authUser.getId()))
                .post(getPost(payload.getPostId()))
                .build()).getId();
    }

    @Override
    @Transactional
    public List<PostResponseMapper> findAllPost() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PostResponseMapper findPostById(AuthUser authUser, Long id) {
        return PostResponseMapper.of(getPost(id));
    }

    private User getUser(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    private Post getPost(final Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }
}
