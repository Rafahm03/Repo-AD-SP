package com.example.ejemplosecurity2.security.errorexceptionhandling;

public class JwtException extends RuntimeException {
    public JwtException(String message) {
        super(message);
    }
}
