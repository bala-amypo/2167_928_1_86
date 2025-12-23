package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.FarmService;
import com.example.demo.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    @Override
    public Farm createFarm(Farm farm, Long ownerId) {

        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10)
            throw new IllegalArgumentException("Invalid pH");

        if (!ValidationUtil.validSeason(farm.getSeason()))
            throw new BadRequestException("Invalid season");

        User owner = userRepo.findById(ownerId)
                .orElseThrow(() -> new BadRequestException("Owner not found"));

        farm.setOwner(owner);
        return farmRepo.save(farm);
    }

    @Override
    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepo.findByOwnerId(ownerId);
    }

    @Override
    public Farm getFarmById(Long farmId) {
        return farmRepo.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}
