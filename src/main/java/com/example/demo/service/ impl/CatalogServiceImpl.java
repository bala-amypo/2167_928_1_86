@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CropRepository cropRepo;
    private final FertilizerRepository fertRepo;

    public Crop addCrop(Crop crop) {
        if (crop.getSuitablePHMin() > crop.getSuitablePHMax())
            throw new BadRequestException("PH min invalid");

        if (!ValidationUtil.validSeason(crop.getSeason()))
            throw new BadRequestException("Invalid season");

        return cropRepo.save(crop);
    }

    public Fertilizer addFertilizer(Fertilizer f) {
        if (!f.getNpkRatio().matches("\\d+-\\d+-\\d+"))
            throw new BadRequestException("Invalid NPK");

        return fertRepo.save(f);
    }

    public List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return cropRepo.findSuitableCrops(ph, water, season);
    }

    public List<Fertilizer> findFertilizersForCrops(List<String> crops) {
        return fertRepo.findAll().stream()
                .filter(f -> crops.stream()
                        .anyMatch(c -> f.getRecommendedForCrops().contains(c)))
                .toList();
    }
}
