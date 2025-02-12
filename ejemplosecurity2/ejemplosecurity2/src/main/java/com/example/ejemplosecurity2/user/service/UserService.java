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

    public User createUser(CreateUserRequest createUserRequest, EnumSet<UserRole> roles) {
        User user =  User.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .roles(Set.of(UserRole.USER))
                .build();

        return userRepository.save(user);
    }

    /*public User createUserWithUserRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(UserRole.USER));
    }

    public User createUserWithAdminRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(UserRole.ADMIN));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public Optional<User> edit(User user) {

        // El username no se puede editar
        // La contraseña se edita en otro método

        return userRepository.findById(user.getId())
                .map(u -> {
                    u.setAvatar(user.getAvatar());
                    u.setFullName(user.getFullName());
                    return userRepository.save(u);
                }).or(() -> Optional.empty());

    }

    public Optional<User> editPassword(UUID userId, String newPassword) {

        // Aquí no se realizan comprobaciones de seguridad. Tan solo se modifica

        return userRepository.findById(userId)
                .map(u -> {
                    u.setPassword(passwordEncoder.encode(newPassword));
                    return userRepository.save(u);
                }).or(() -> Optional.empty());

    }

    public void delete(User user) {
        deleteById(user.getId());
    }

    public void deleteById(UUID id) {
        // Prevenimos errores al intentar borrar algo que no existe
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
    }*/
}