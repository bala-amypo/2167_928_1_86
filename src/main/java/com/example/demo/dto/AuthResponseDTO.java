package com.example.demo.dto;

public class AuthResponseDTO {
    private Long id;
    private String email;
    private String token;

    public AuthResponseDTO(Long id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getToken() { return token; }
}
