package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepo;

    public SuggestionServiceImpl(FarmService farmService, CatalogService catalogService, SuggestionRepository suggestionRepo) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepo = suggestionRepo;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);
        
        // Find suitable crops
        List<Crop> crops = catalogService.findSuitableCrops(
            farm.getSoilPH(), 
            farm.getWaterLevel(), 
            farm.getSeason()
        );
        
        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .collect(Collectors.toList());

        // Find fertilizers for those crops
        List<Fertilizer> ferts = catalogService.findFertilizersForCrops(cropNames);

        // Build result strings
        String suggestedCrops = String.join(",", cropNames);
        String suggestedFertilizers = ferts.stream()
                .map(Fertilizer::getName)
                .collect(Collectors.joining(","));

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(suggestedCrops)
                .suggestedFertilizers(suggestedFertilizers)
                .build();
            
        return suggestionRepo.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return suggestionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
    }
}