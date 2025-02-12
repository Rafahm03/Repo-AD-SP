package com.example.ejemplosecurity2.user.service;

import com.example.ejemplosecurity2.user.dto.CreateUserRequest;
import com.example.ejemplosecurity2.user.model.User;
import com.example.ejemplosecurity2.user.model.UserRole;
import com.example.ejemplosecurity2.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest) {
        User user =  User.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);
    }
}