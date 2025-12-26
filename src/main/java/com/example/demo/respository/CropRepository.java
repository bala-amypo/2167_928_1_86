public interface CropRepository extends JpaRepository<Crop, Long> {

    @Query("""
      SELECT c FROM Crop c
      WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax
      AND c.requiredWater <= :water
      AND c.season = :season
    """)
    List<Crop> findSuitableCrops(Double ph, Double water, String season);
}
