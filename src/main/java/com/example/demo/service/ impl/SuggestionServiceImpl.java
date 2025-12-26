@Override
public Suggestion generateSuggestion(Long farmId) {
    Farm farm = farmService.getFarmById(farmId);
    
    // Find crops based on farm conditions
    List<Crop> crops = catalogService.findSuitableCrops(
        farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason()
    );
    
    String cropNamesStr = crops.stream()
            .map(Crop::getName)
            .collect(java.util.stream.Collectors.joining(","));

    // Find fertilizers for those crops
    List<String> cropNames = crops.stream().map(Crop::getName).toList();
    List<com.example.demo.entity.Fertilizer> ferts = catalogService.findFertilizersForCrops(cropNames);
    
    String fertNamesStr = ferts.stream()
            .map(com.example.demo.entity.Fertilizer::getName)
            .collect(java.util.stream.Collectors.joining(","));

    // Build the suggestion object
    Suggestion suggestion = Suggestion.builder()
            .farm(farm)
            .suggestedCrops(cropNamesStr)
            .suggestedFertilizers(fertNamesStr)
            .build();
            
    return suggestionRepo.save(suggestion);
}