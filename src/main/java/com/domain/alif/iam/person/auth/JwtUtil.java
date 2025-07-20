package com.domain.alif.iam.person.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "my-very-secure-and-long-secret-key-256-bit-value123"; // Must be ≥ 32
                                                                                                    // chars
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final JwtParser parser = Jwts.parser().verifyWith(key).build();

    public String generateToken(String subject) {
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(key)
                .compact();
    }

    public Claims extractClaims(String token) {
        return parser.parseSignedClaims(token).getPayload();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if (bearer != null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
