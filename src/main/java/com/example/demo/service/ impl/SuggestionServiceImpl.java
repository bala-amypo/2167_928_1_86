package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.SuggestionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionServiceImpl {

    private final FarmServiceImpl farmService;
    private final CatalogServiceImpl catalogService;
    private final SuggestionRepository suggestionRepository;

    public SuggestionServiceImpl(FarmServiceImpl farmService,
                                 CatalogServiceImpl catalogService,
                                 SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

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

        return suggestionRepository.save(suggestion);
    }

    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
