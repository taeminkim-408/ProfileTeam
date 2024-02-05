package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.domain.Post;
import org.example.dto.request.CommentRequest;
import org.example.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/create")
    public void commentCreate (@RequestBody CommentRequest commentRequest) {commentService.create(commentRequest);}

    @GetMapping("/comment/read/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/comment/delete/{cId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long cId) {
        commentService.deleteComment(cId);
        return ResponseEntity.ok().build();
    }
}