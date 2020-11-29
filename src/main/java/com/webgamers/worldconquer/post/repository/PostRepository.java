package com.webgamers.worldconquer.post.repository;

import com.webgamers.worldconquer.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
