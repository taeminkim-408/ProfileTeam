package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.UserRequest;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping("/insta")
    public void userCreate (@RequestBody UserRequest userRequest){
        userService.create(userRequest);
    }
}