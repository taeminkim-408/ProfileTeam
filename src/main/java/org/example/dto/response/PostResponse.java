package org.example.dto.response;

import lombok.Data;

@Data
public class PostResponse {
    private Long postId;
    private String postText;
    private Long postLike;
    private String postImage;
    private Long userId;
}
