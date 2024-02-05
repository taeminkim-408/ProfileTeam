package org.example.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentRequest {
    private Long cId;
    private String cComment;
    private Long postId;
    private Long userId;
}
