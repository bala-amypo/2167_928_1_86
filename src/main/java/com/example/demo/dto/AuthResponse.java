package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private Long userId;    // Added to match AuthServiceImpl call
    private String email;   // Added to match AuthServiceImpl call
    private String role;    // Added to match AuthServiceImpl call

    // Constructor for just token (to maintain compatibility with other tests)
    public AuthResponse(String token) {
        this.token = token;
    }
}