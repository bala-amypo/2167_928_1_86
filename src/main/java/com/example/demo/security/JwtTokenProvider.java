package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String SECRET = "YourSecretKeyForJWTAuthenticationMustBeLongEnough";

    public String createToken(Long userId, String email, String role) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("role", role);
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    public boolean validateToken(String token) {
        try { Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token); return true; } 
        catch (Exception e) { return false; }
    }

    public String getEmail(String token) { return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject(); }
    public Long getUserId(String token) { return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().get("userId", Long.class); }
    public String getRole(String token) { return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().get("role", String.class); }
}