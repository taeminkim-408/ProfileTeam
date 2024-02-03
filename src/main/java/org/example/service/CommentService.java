package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.domain.Post;
import org.example.domain.User;
import org.example.dto.request.CommentRequest;
import org.example.repository.CommentRepository;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        try {
            Post post = postRepository.findById(request.getPostId())
                    .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + request.getPostId()));

            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.getUserId()));

            Comment comment = Comment.builder()
                    .cName(request.getCName())
                    .cComment(request.getCComment())
                    .c_Image(request.getC_Image())
                    .regDate(new Timestamp(System.currentTimeMillis()))
                    .post(post)
                    .user(user)
                    .build();

            commentRepository.save(comment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create comment: " + e.getMessage(), e);
        }
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPost_PostId(postId);
    }

    public void deleteComment(Long cId) {
        commentRepository.deleteById(cId);
    }
}
