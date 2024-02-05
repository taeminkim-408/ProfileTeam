package org.example.dto.response;

import lombok.Data;

@Data
public class CommentResponse {
    private Long cId;
    private String cComment;
    private Long postId;
    private Long userId;
}

