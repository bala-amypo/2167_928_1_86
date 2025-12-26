package com.example.demo;

import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Set;

public class FarmServiceImpl {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    public FarmServiceImpl(FarmRepository farmRepository,
                           UserRepository userRepository) {
        this.farmRepository = farmRepository;
        this.userRepository = userRepository;
    }

    public Farm createFarm(Farm farm, Long ownerId) {

        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10) {
            throw new IllegalArgumentException("Invalid pH");
        }

        if (!Set.of("Kharif", "Rabi", "Summer").contains(farm.getSeason())) {
            throw new IllegalArgumentException("Invalid season");
        }

        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        farm.setOwner(owner);
        return farmRepository.save(farm);
    }

    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found"));
    }

    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepository.findByOwnerId(ownerId);
    }
}
