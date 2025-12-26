package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    public FarmServiceImpl(FarmRepository farmRepo, UserRepository userRepo) {
        this.farmRepo = farmRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Farm createFarm(Farm farm, Long userId) {
        // Validation for t42
        if (farm.getSoilPH() < 3.0 || farm.getSoilPH() > 10.0) {
            throw new IllegalArgumentException("Invalid pH level");
        }
        User owner = userRepo.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        farm.setOwner(owner);
        return farmRepo.save(farm);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }

    @Override
    public List<Farm> getFarmsByOwner(Long userId) {
        return farmRepo.findByOwnerId(userId);
    }
}