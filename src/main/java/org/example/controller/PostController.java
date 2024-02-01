package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Post;
import org.example.domain.User;
import org.example.dto.request.PostRequest;
import org.example.dto.request.UserRequest;
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

1. 선빵
2. 프론트랑 연결

3. 구글 로그인?
4. s3이미지 업로드
