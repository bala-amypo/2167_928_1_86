package com.example.demo.service.impl;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User register(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Ideally encode this with BCryptPasswordEncoder
        return userRepository.save(user);
    }

    public User login(UserRequestDTO dto) {
        return userRepository.findByEmail(dto.getEmail())
            .filter(u -> u.getPassword().equals(dto.getPassword())) // match password
            .orElse(null);
    }
}
