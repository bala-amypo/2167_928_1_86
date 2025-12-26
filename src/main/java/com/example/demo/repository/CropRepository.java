@Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph " +
       "AND c.requiredWater <= :water AND c.season = :season")
List<Crop> findSuitableCrops(Double ph, Double water, String season);

// For t36 which uses a simplified version
@Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph AND c.season = :season")
List<Crop> findSuitableCrops(Double ph, String season);