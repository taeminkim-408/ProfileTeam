package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userIntro;
    private String userImage;
}
