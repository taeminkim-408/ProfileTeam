package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.dto.request.UserRequest;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create( UserRequest request ){
        User user = User.builder()
                .userId(request.getUserId())
                .userName(request.getUserName())
                .userEmail(request.getUserEmail())
                .userImage(request.getUserImage())
                .build();
        userRepository.save(user);
    }
}
