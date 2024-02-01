package org.example.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.Post;
import org.example.domain.User;
import org.example.dto.request.PostRequest;
import org.example.dto.request.UserRequest;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

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

    public List<Post> read() {
        return postRepository.findAll();
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
