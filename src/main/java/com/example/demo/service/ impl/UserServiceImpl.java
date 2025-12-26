package com.example.demo;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl extends UserServiceImpl {

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder encoder) {
        super(userRepository, encoder);
    }
}
