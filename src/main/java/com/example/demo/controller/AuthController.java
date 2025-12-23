package com.example.demo.controller;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public User register(@RequestBody UserRequestDTO dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserRequestDTO dto) {
        User user = userService.login(dto);
        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}
