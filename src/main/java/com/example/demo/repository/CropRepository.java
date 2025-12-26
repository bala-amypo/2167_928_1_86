@Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph AND c.season = :season")
List<Crop> findSuitableCrops(@Param("ph") Double ph, @Param("season") String season);