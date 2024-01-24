package org.example.controller;

import org.example.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<UserDto> home() {
        UserDto userDto=new UserDto();
        userDto.setUserId(1L);
        userDto.setUserName("이한나");
        return ResponseEntity.ok().body(userDto);
    }
}
