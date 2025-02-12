package com.example.ejemplosecurity2.user.dto;

import com.example.ejemplosecurity2.user.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token
) {

    public static UserResponse of (User user) {
        return new UserResponse(user.getId(), user.getUsername(), null);
    }

    public static UserResponse of (User user, String token) {
        return new UserResponse(user.getId(), user.getUsername(), token);
    }

}
