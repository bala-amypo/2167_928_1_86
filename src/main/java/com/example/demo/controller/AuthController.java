package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {

        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(req.getPassword())
                .build();

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {

        User user = userService.findByEmail(req.getEmail());

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(
                AuthResponse.builder()
                        .token(token)
                        .userId(user.getId())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build()
        );
    }
}
