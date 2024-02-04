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
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void create( CommentRequest request ){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.getUserId()));

        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + request.getPostId()));

        Comment comment = Comment.builder()
                .cId(request.getCId())
                .cName(request.getCName())
                .cComment(request.getCComment())
                .c_Image(request.getC_Image())
                .post(post)
                .user(user)
                .build();
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsByUserAndPost(Long userId, Long postId) {
        return commentRepository.findByUser_UserIdAndPost_PostId(userId, postId);
    }

    public void deleteComment(Long cId) {
        commentRepository.deleteById(cId);
    }
}
