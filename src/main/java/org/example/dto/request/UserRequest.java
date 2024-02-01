package org.example.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRequest {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userImage;
}