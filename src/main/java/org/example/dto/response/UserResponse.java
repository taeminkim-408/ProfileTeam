package org.example.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userImage;
}
