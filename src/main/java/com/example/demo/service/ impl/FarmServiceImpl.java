package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;

import java.util.List;

public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    public FarmServiceImpl(FarmRepository f, UserRepository u) {
        this.farmRepo = f;
        this.userRepo = u;
    }

    public Farm createFarm(Farm farm, Long ownerId) {
        User owner = userRepo.findById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner"));

        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10)
            throw new IllegalArgumentException("pH");

        if (!ValidationUtil.validSeason(farm.getSeason()))
            throw new IllegalArgumentException("season");

        farm.setOwner(owner);
        return farmRepo.save(farm);
    }

    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepo.findByOwnerId(ownerId);
    }

    public Farm getFarmById(Long id) {
        return farmRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}
