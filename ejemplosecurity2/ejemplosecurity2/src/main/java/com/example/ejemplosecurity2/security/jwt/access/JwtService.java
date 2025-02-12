package com.example.ejemplosecurity2.security.jwt.access;

import com.example.ejemplosecurity2.user.model.User;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInMinuter;

    private JwtParser jwtParser;

    private SecretKey secretKey;

    @PostConstruct
    public void init(){
        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        jwtParser = Jwts.parser().verifyWith(secretKey).build();
    }

    public String generatedRoken(User user){

        Date tokeExpirationDate =
                Date.from(LocalDateTime
                        .now()
                        .plusMinutes(jwtLifeInMinuter)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                );

        return Jwts.builder()
                .header()
                .type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .issueAt(new Date())
                .expireation(tokenExpirationDate)
                .signWith
    }


}
