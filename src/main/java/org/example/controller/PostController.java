package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Post;
import org.example.dto.request.PostRequest;
import org.example.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {
    private final PostService postService;

    @PostMapping("/post/create")
    public void postCreate (@RequestBody PostRequest postRequest){
        postService.create(postRequest);
    }

    @GetMapping("/post/read")
    public ResponseEntity<List<Post>> postRead() {
        List<Post> posts = postService.read();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/post/readbyid/{userId}")
    public ResponseEntity<List<Post>> postReadByUserId(@PathVariable Long userId) {
        List<Post> posts = postService.postReadByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    @PatchMapping("/post/update/{id}")
    public ResponseEntity<Post> postUpdate(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        Post updatedPost = postService.update(id, postRequest);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<Void> postDelete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}
