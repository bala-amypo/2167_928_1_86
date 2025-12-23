package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogServiceImpl {
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    public List<Crop> findSuitableCrops(Double ph, String soilType) {
        return cropRepository.findSuitableCrops(ph, soilType);
    }

    public List<Fertilizer> findRecommendedFertilizers(String cropName) {
        List<Fertilizer> fertilizers = fertilizerRepository.findAll();
        return fertilizers.stream()
                .filter(f -> f.getRecommendedForCrops() != null && f.getRecommendedForCrops().contains(cropName))
                .toList();
    }
}
