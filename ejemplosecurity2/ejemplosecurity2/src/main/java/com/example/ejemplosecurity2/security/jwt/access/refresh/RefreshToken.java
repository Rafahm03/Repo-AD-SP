package com.example.ejemplosecurity2.security.jwt.access.refresh;

import com.example.ejemplosecurity2.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {
    @Id
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name="user_id", columnDefinition = "uuid")
    private User user;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expireAt;

    @Builder.Default
    private Instant createdAt = Instant.now();
}
