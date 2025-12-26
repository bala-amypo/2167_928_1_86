package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmService farmService, CatalogService catalogService, SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId); // Validates farm exists [cite: 264]
        
        List<Crop> crops = catalogService.findSuitableCrops(farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());
        List<String> cropNames = crops.stream().map(Crop::getName).collect(Collectors.toList());
        
        // Convert to comma-separated string [cite: 265]
        String cropCsv = String.join(",", cropNames);

        List<String> fertNames = catalogService.findFertilizersForCrops(cropNames)
            .stream().map(f -> f.getName()).collect(Collectors.toList());
        String fertCsv = String.join(",", fertNames);

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(cropCsv)
                .suggestedFertilizers(fertCsv)
                .build();
        
        // Note: @PrePersist in Suggestion entity handles createdAt [cite: 230, 321]
        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return suggestionRepository.findById(id)
            .orElseThrow(() -> new com.example.demo.exception.ResourceNotFoundException("Suggestion not found"));
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}