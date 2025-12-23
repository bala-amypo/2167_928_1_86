package com.example.demo.repository;

import com.example.demo.entity.User;
import java.util.List;

public interface UserRepository {
    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
}
