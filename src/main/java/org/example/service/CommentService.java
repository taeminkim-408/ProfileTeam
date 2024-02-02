package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.dto.request.CommentRequest;
import org.example.repository.CommentRepository;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createComment(CommentRequest request) {
        Comment comment = Comment.builder()
                .cId(request.getCId())
                .cName(request.getCName())
                .cComment(request.getCComment())
                .c_Image(request.getC_Image())
                .regDate(new Timestamp(System.currentTimeMillis()))
                .post(postRepository.findById(request.getPostId()).orElseThrow(() -> new RuntimeException("Post not found")))
                .user(userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found")))
                .build();
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPost_postId(postId);
    }

    public void deleteComment(Long cId) {
        commentRepository.deleteById(cId);
    }
}
