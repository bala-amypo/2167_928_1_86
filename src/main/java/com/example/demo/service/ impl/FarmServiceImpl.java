package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;

import java.util.List;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    // 🔴 REQUIRED BY TESTS
    public FarmServiceImpl(FarmRepository farmRepository, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10) {
            throw new IllegalArgumentException("pH");
        }
        if (!ValidationUtil.validSeason(farm.getSeason())) {
            throw new IllegalArgumentException("Invalid season");
        }
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        farm.setOwner(owner);
        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}
