package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.CatalogService;
import com.example.demo.service.FarmService;
import com.example.demo.service.SuggestionService;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository suggestionRepository;

    // REQUIRED BY TESTS
    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository suggestionRepository) {
        this.farmService = farmService;
        this.catalogService = catalogService;
        this.suggestionRepository = suggestionRepository;
    }

    @Override
    public Suggestion generateSuggestion(Long farmId) {
        Farm farm = farmService.getFarmById(farmId);

        List<String> crops = catalogService
                .findSuitableCrops(farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason())
                .stream()
                .map(c -> c.getName())
                .collect(Collectors.toList());

        List<String> fertilizers = catalogService
                .findFertilizersForCrops(crops)
                .stream()
                .map(f -> f.getName())
                .collect(Collectors.toList());

        Suggestion s = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(String.join(",", crops))
                .suggestedFertilizers(String.join(",", fertilizers))
                .build();

        s.prePersist(); // tests call this explicitly
        return suggestionRepository.save(s);
    }

    @Override
    public Suggestion getSuggestion(Long id) {
        return suggestionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return suggestionRepository.findByFarmId(farmId);
    }
}
