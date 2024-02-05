package org.example.dto.response;

import lombok.Data;

@Data
public class CommentResponse {
    private Long commIdId;
    private String commComment;
    private Long postId;
    private Long userId;
}

