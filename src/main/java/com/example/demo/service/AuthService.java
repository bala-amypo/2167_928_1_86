package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO register(UserRequestDTO userRequestDTO);
    AuthResponseDTO login(UserRequestDTO userRequestDTO);
}
