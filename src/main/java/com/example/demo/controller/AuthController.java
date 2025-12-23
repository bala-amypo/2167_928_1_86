package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.example.demo.dto.UserRequestDTO;

@RestController
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        // Add user registration logic here (e.g., save user)
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        // Add login logic here (e.g., authenticate and return JWT)
        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }
}
