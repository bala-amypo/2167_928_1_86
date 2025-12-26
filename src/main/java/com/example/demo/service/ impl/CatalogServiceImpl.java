package com.example.demo;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FertilizerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogServiceImpl {

    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        this.cropRepository = cropRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Fertilizer addFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    public List<Crop> findSuitableCrops(double ph, double water, String season) {
        return cropRepository.findAll().stream()
                .filter(c ->
                        ph >= c.getSuitablePHMin() &&
                        ph <= c.getSuitablePHMax() &&
                        water >= c.getRequiredWater() &&
                        season.equalsIgnoreCase(c.getSeason()))
                .collect(Collectors.toList());
    }

    public List<Fertilizer> findFertilizersForCrops(List<String> cropNames) {
        return fertilizerRepository.findAll().stream()
                .filter(f ->
                        cropNames.stream()
                                .anyMatch(name -> f.getRecommendedForCrops().contains(name)))
                .collect(Collectors.toList());
    }
}
