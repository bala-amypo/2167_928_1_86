package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository repo;

    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository repo) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.repo = repo;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        List<Crop> crops = catalogService.findSuitableCrops(
                farm.getSoilPH(),
                farm.getWaterLevel(),
                farm.getSeason()
        );

        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .toList();

        List<Fertilizer> fertilizers =
                catalogService.findFertilizersForCrops(cropNames);

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(String.join(",", cropNames))
                .suggestedFertilizers(
                        fertilizers.stream()
                                .map(Fertilizer::getName)
                                .collect(Collectors.joining(",")))
                .build();

        return repo.save(suggestion);
    }

    // ✅ STRONG RETURN TYPE
    @Override
    public Suggestion getSuggestion(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ STRONG RETURN TYPE
    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return repo.findByFarmId(farmId);
    }
}
