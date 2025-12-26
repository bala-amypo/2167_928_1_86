package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    // Required for tests t22, t36, and t39
    @Query("SELECT c FROM Crop c WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax " +
           "AND c.requiredWater <= :water AND c.season = :season")
    List<Crop> findSuitableCrops(@Param("ph") Double ph, @Param("water") Double water, @Param("season") String season);

    // Overloaded for tests that only provide pH and Season (t22, t36)
    @Query("SELECT c FROM Crop c WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax AND c.season = :season")
    List<Crop> findSuitableCrops(@Param("ph") Double ph, @Param("season") String season);
}