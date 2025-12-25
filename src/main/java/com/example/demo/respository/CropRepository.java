package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // 🔴 used by services
    @Query("""
        SELECT c FROM Crop c
        WHERE c.suitablePHMin <= :ph
        AND c.suitablePHMax >= :ph
        AND c.season = :season
    """)
    List<Crop> findSuitableCrops(Double ph, String season);

    // 🔴 overload for tests
    default List<Crop> findSuitableCrops(double ph, String season) {
        return findSuitableCrops(ph, season);
    }
}
