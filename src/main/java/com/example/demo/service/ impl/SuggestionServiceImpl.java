@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmService farmService;
    private final CatalogService catalogService;
    private final SuggestionRepository repo;

    public Suggestion generateSuggestion(Long farmId) {

        Farm farm = farmService.getFarmById(farmId);

        List<Crop> crops = catalogService.findSuitableCrops(
                farm.getSoilPH(), farm.getWaterLevel(), farm.getSeason());

        List<String> cropNames = crops.stream().map(Crop::getName).toList();

        List<Fertilizer> fertilizers =
                catalogService.findFertilizersForCrops(cropNames);

        Suggestion s = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(String.join(",", cropNames))
                .suggestedFertilizers(
                        fertilizers.stream().map(Fertilizer::getName).collect(Collectors.joining(",")))
                .build();

        return repo.save(s);
    }

    public Suggestion getSuggestion(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));
    }

    public List<Suggestion> getSuggestionsByFarm(Long farmId) {
        return repo.findByFarmId(farmId);
    }
}
