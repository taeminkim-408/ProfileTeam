package org.example.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private Long postId;
    private String postText;
    private long postLike;
    private String postImage;
    private LocalDateTime regDate;
    private LocalDateTime ModDate;
    private UserBasicInfoDTO userId;

    @Getter
    @Setter
    public static class UserBasicInfoDTO {
        private Long userId;
    }
}


