package com.example.ejemplosecurity2.user.dto;

public record LoginRequest(
        String username,
        String password
) {
}