package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.dto.request.CommentRequest;
import org.example.dto.response.CommentResponse;
import org.example.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/create")
    public ResponseEntity<Void> createComment(@RequestBody CommentRequest commentRequest) {
        commentService.createComment(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/comment/read/{postId}")
    public ResponseEntity<List<CommentResponse>> getCommentsByPostId(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        List<CommentResponse> commentResponses = mapToCommentResponses(comments);
        return ResponseEntity.ok(commentResponses);
    }

    @DeleteMapping("/comment/delete/{cId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long cId) {
        commentService.deleteComment(cId);
        return ResponseEntity.ok().build();
    }
    private List<CommentResponse> mapToCommentResponses(List<Comment> comments) {
        return comments.stream()
                .map(comment -> {
                    CommentResponse response = new CommentResponse();
                    response.setCId(comment.getCId());
                    response.setCName(comment.getCName());
                    response.setCComment(comment.getCComment());
                    response.setC_Image(comment.getC_Image());
                    response.setPostId(comment.getPost().getPostId());
                    response.setUserId(comment.getUser().getUserId());
                    return response;
                })
                .collect(Collectors.toList());
    }
}