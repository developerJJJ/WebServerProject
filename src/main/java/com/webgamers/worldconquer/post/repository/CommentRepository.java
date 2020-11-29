package com.webgamers.worldconquer.post.repository;

import com.webgamers.worldconquer.post.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
