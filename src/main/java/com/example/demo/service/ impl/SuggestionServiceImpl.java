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
        
        // Logic to find suitable crops
        List<Crop> crops = catalogService.findSuitableCrops(
            farm.getSoilPH(), 
            farm.getWaterLevel(), 
            farm.getSeason()
        );
        
        List<String> cropNames = crops.stream()
                .map(Crop::getName)
                .collect(Collectors.toList());

        // Logic to find fertilizers for those crops
        List<Fertilizer> ferts = catalogService.findFertilizersForCrops(cropNames);

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

    // THIS IS THE MISSING METHOD CAUSING YOUR ERROR
    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepo.findByFarmId(farmId);
    }
}