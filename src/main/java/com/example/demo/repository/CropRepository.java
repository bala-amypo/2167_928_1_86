package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    // Required for t36 and t39
    @Query("SELECT c FROM Crop c WHERE :ph BETWEEN c.suitablePHMin AND c.suitablePHMax " +
           "AND c.requiredWater <= :water AND c.season = :season")
    List<Crop> findSuitableCrops(@Param("ph") Double ph, @Param("water") Double water, @Param("season") String season);

    // Required for t22 (Simplified 2-param version)
    default List<Crop> findSuitableCrops(Double ph, String season) {
        return findSuitableCrops(ph, Double.MAX_VALUE, season);
    }
}