package org.example.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentRequest {
    private Long cId;
    private String cName;
    private String cComment;
    private String c_Image;
    private Long postId;
    private Long userId;
}
