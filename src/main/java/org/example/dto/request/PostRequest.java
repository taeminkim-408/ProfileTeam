package org.example.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class PostRequest {
    private Long postId;
    private String postText;
    private Long postLike;
    private String postImage;
    private Long userId;
}
