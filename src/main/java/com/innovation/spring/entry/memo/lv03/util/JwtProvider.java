package com.innovation.spring.entry.memo.lv03.util;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;

@Component
public class JwtProvider {

    private final long ACCESS_TOKEN_EXPIRED_TIME = Duration.ofMinutes(30).toMillis();
    private final SecretKey accessTokenSecretKey;

    public JwtProvider(
            @Value("${spring.jwt.secret.access}") String accessSecretKey
    ) {
        this.accessTokenSecretKey = new SecretKeySpec(
                accessSecretKey.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS512.key().build().getAlgorithm()
        );
    }

    /**
     * AccessToken 생성
     * @param userId
     * @return AccessToken(String)
     */
    public String generateAccessToken(Long userId) {
        Date now = new Date();

        return Jwts.builder()
                .claim("id", userId)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + ACCESS_TOKEN_EXPIRED_TIME))
                .signWith(accessTokenSecretKey)
                .compact();
    }
}
