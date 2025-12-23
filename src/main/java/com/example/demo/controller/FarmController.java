package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.FertilizerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farm")
public class FarmController {

    private final FertilizerRepository fertilizerRepository;

    public FarmController(FertilizerRepository fertilizerRepository) {
        this.fertilizerRepository = fertilizerRepository;
    }

    @PostMapping("/suggest")
    public List<Fertilizer> suggestFertilizer(
            @RequestBody FarmRequest request,
            Authentication authentication) {

        return fertilizerRepository
                .findBySuitableCropAndSoilType(
                        request.getCrop(),
                        request.getSoilType());
    }
}
