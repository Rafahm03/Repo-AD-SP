package com.example.ejemplosecurity2.security.jwt.access.refresh;

import com.example.ejemplosecurity2.user.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly=true)
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    public RefreshToken created (User user){
        return refreshTokenRepository.save(
                RefreshToken.builder(
                        .user(user)
                        .token(UUID.randomUUID().toString())
                        .expireAt(Instant.now().plusSeconds())
                        .build()
                );
        )
    }
}
