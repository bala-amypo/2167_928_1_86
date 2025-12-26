package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import com.example.demo.util.ValidationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public CatalogServiceImpl(CropRepository c, FertilizerRepository f) {
        this.cropRepo = c;
        this.fertRepo = f;
    }

    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax())
            throw new BadRequestException("PH min");

        if (!ValidationUtil.validSeason(crop.getSeason()))
            throw new BadRequestException("Invalid season");

        return cropRepo.save(crop);
    }

    public Fertilizer addFertilizer(Fertilizer f) {
        if (!f.getNpkRatio().matches("\\d+-\\d+-\\d+"))
            throw new BadRequestException("NPK");

        return fertRepo.save(f);
    }

    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepo.findSuitableCrops(ph, water, season);
    }

    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return fertRepo.findAll().stream()
                .filter(f -> crops.stream()
                        .anyMatch(c -> f.getRecommendedForCrops().contains(c)))
                .collect(Collectors.toList());
    }
}
