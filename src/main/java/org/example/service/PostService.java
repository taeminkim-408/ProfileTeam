package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Post;
import org.example.domain.User;
import org.example.dto.request.PostRequest;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);


    public void create( PostRequest request ){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.getUserId()));

        Post post = Post.builder()
                .postId(request.getPostId())
                .postText(request.getPostText())
                .postLike(request.getPostLike())
                .postImage(request.getPostImage())
                .user(user)
                .build();

        postRepository.save(post);
    }

    public List<Post> read()  {
        return postRepository.findAll();
    }

    public List<Post> postReadByUserId(Long userId) {
        return postRepository.findByUser_UserId(userId);
    }

    public Post update(Long id, PostRequest request) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        post.setPostText(request.getPostText());
        post.setPostImage(request.getPostImage());
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
