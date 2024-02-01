package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.dto.request.UserRequest;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping("/user/create")
    public void userCreate (@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
    }

    @GetMapping("/user/read")
    public ResponseEntity<List<User>> userRead() {
        List<User> users = userService.read();
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/user/update/{id}")
    public ResponseEntity<User> userUpdate(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User updatedUser = userService.update(id, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> userDelete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}