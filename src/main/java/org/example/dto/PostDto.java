package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long userId;
    private Long postId;
    private String postText;
    private int postLike;
    private String postImage;
}
