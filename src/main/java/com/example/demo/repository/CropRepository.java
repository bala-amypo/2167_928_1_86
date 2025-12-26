package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    // Add this overloaded-style method for the tests
    @Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph AND c.season = :season")
    List<Crop> findSuitableCrops(double ph, String season);

    // Keep the one used by your service
    @Query("SELECT c FROM Crop c WHERE c.suitablePHMin <= :ph AND c.suitablePHMax >= :ph AND c.season = :season")
    List<Crop> findSuitableCrops(Double ph, Double water, String season);
}