package org.example.dto.response;

import lombok.Data;

@Data
public class CommentResponse {
    private Long cId;
    private String cName;
    private String cComment;
    private String c_Image;
    private Long postId;
    private Long userId;
}

