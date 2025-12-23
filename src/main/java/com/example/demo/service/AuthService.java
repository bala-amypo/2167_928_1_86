package com.example.demo.service;

import com.example.demo.dto.AuthResponseDTO;
import com.example.demo.dto.UserRequestDTO;

public interface AuthService {
    AuthResponseDTO register(UserRequestDTO request);
    AuthResponseDTO login(UserRequestDTO request);
}
    