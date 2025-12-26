@Override
public Suggestion generateSuggestion(Long farmId) {
    Farm farm = farmService.getFarmById(farmId);
    
    List<Crop> crops = catalogService.findSuitableCrops(farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());
    String cropNames = crops.stream()
            .map(Crop::getName)
            .collect(java.util.stream.Collectors.joining(","));

    List<String> namesList = crops.stream().map(Crop::getName).collect(java.util.stream.Collectors.toList());
    
    String fertilizerNames = catalogService.findFertilizersForCrops(namesList).stream()
            .map(Fertilizer::getName)
            .collect(java.util.stream.Collectors.joining(","));

    Suggestion suggestion = Suggestion.builder()
            .farm(farm)
            .suggestedCrops(cropNames)
            .suggestedFertilizers(fertilizerNames)
            .build();
            
    return suggestionRepository.save(suggestion);
}