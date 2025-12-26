@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepo;
    private final UserRepository userRepo;

    public Farm createFarm(Farm farm, Long ownerId) {
        if (farm.getSoilPH() < 3 || farm.getSoilPH() > 10)
            throw new IllegalArgumentException("Invalid pH");

        if (!ValidationUtil.validSeason(farm.getSeason()))
            throw new IllegalArgumentException("Invalid season");

        User owner = userRepo.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        farm.setOwner(owner);
        return farmRepo.save(farm);
    }

    public List<Farm> getFarmsByOwner(Long ownerId) {
        return farmRepo.findByOwnerId(ownerId);
    }

    public Farm getFarmById(Long farmId) {
        return farmRepo.findById(farmId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }
}
