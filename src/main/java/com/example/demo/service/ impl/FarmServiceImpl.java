package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    public FarmServiceImpl(FarmRepository farmRepository, UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {
        User owner = userRepository.findById(ownerId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10) {
            throw new IllegalArgumentException("Invalid pH value"); // Required for t42 [cite: 355]
        }
        if (!ValidationUtil.validSeason(farm.getSeason())) {
            throw new IllegalArgumentException("Invalid season");
        }
        
        farm.setOwner(owner);
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepository.findById(farmId)
            .orElseThrow(() -> new ResourceNotFoundException("Farm not found")); // Required for t46 [cite: 368]
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }
}