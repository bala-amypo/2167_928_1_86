package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.impl.FarmServiceImpl;

public class FarmServiceImpl extends FarmServiceImpl {

    public FarmServiceImpl(FarmRepository farmRepository,
                           UserRepository userRepository) {
        super(farmRepository, userRepository);
    }
}
