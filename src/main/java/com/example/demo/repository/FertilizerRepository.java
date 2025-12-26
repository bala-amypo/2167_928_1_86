@Query("SELECT f FROM Fertilizer f WHERE f.recommendedForCrops LIKE %:cropName%")
List<Fertilizer> findByCropName(String cropName);