package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.exception.ResourceNotFoundException;
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
        if (!ValidationUtil.validPH(farm.getSoilPH())) {
            throw new IllegalArgumentException("Invalid pH level");
        }
        User owner = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        farm.setOwner(owner);
        return farmRepo.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwner(Long userId) {
        return farmRepo.findByOwnerId(userId);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}