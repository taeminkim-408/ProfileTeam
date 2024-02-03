package org.example.dto.request;

import lombok.Data;

@Data
public class CommentRequest {
    private String cName;
    private String cComment;
    private Long postId;
    private Long userId;
    private String c_Image;
}
