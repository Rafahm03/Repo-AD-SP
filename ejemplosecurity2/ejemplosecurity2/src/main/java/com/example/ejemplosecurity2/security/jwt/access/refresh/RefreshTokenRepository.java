package com.example.ejemplosecurity2.security.jwt.access.refresh;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository  extends JpaRepository<RefreshToken, UUID> {

    Optional<RefreshToken> findByToken(String string);
}
