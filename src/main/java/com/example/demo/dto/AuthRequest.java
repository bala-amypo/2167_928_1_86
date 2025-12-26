package com.example.demo.dto;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class AuthRequest {
    private String email;
    private String password;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}