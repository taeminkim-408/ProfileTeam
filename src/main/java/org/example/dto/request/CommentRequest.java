package org.example.dto.request;

import lombok.Data;

@Data
public class CommentRequest {
    private Long cId;
    private String cName;
    private String cComment;
    private Long postId;
    private Long userId;
    private String c_Image;
}
