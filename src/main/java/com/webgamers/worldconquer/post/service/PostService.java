package com.webgamers.worldconquer.post.service;

import com.webgamers.worldconquer.post.dto.CommentRegisterRequestDto;
import com.webgamers.worldconquer.post.dto.PostRegisterRequestDto;
import com.webgamers.worldconquer.post.mapper.PostResponseMapper;
import com.webgamers.worldconquer.user.security.AuthUser;

import java.util.List;

public interface PostService {
    Long registerPost(final AuthUser authUser, final PostRegisterRequestDto payload);
    Long registerComment(final AuthUser authUser, final CommentRegisterRequestDto payload);
    List<PostResponseMapper> findAllPost();
    PostResponseMapper findPostById(final AuthUser authUser, final Long id);

    void deletePostById(Long id);
}
