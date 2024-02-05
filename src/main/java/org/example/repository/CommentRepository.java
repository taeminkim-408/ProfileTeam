package org.example.repository;

import org.example.domain.Comment;
import org.example.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //List<Comment> findByUser_UserId(Long userId);
    List<Comment> findByPost_PostId(Long postId);
}