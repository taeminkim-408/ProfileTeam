package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Comment;
import org.example.dto.request.CommentRequest;
import org.example.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/create")
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentService.createComment(commentRequest);
    }

    @GetMapping("/comment/read/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @DeleteMapping("/comment/delete/{cId}")
    public void deleteComment(@PathVariable Long cId) {
        commentService.deleteComment(cId);
    }
}
