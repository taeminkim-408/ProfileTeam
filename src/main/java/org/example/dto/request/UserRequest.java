package org.example.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userImage;
}