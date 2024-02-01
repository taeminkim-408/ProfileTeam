package org.example.dto.request;

import lombok.Data;

@Data
public class PostRequest {
    private Long postId;
    private String postText;
    private Long postLike;
    private String postImage;
    private Long userId;
}
