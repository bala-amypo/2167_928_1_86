package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.*;
import java.util.stream.Collectors;
import java.util.*;

public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository repo;

    public SuggestionServiceImpl(FarmService f, CatalogService c, SuggestionRepository r) {
        this.farmService = f;
        this.catalogService = c;
        this.repo = r;
    }

    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        List<Crop> crops = catalogService.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        List<String> cropNames = crops.stream().map(Crop::getName).toList();
        List<Fertilizer> ferts = catalogService.findFertilizersForCrops(cropNames);

        Suggestion s = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(String.join(",", cropNames))
                .suggestedFertilizers(
                        ferts.stream().map(Fertilizer::getName).collect(Collectors.joining(",")))
                .build();

        return repo.save(s);
    }

    public Suggestion getSuggestion(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return repo.findByFarmId(farmId);
    }
}
