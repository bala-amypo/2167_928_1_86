package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public AuthResponse register(AuthRequest request) {
        User user = new User(null, request.getUsername(), "", request.getPassword(), "USER");
        userService.register(user);
        return new AuthResponse("User registered successfully");
    }
}
