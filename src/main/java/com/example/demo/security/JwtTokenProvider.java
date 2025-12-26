package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtTokenProvider {

    private final String secret = "secret";

    public String createToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Object validateToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }

    public Long getUserId(String token) {
        return ((Number) getClaims(token).get("userId")).longValue();
    }

    public String getEmail(String token) {
        return (String) getClaims(token).get("email");
    }

    public String getRole(String token) {
        return (String) getClaims(token).get("role");
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody();
    }
}
