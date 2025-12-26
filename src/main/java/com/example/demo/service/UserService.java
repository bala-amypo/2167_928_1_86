package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User register(User user); // Must be named 'register' per requirements [cite: 55]
    User findByEmail(String email);
    User findById(Long id);
}