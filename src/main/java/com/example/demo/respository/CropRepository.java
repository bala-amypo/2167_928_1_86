package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    @Query("SELECT c FROM Crop c WHERE :temp BETWEEN c.minTemp AND c.maxTemp AND c.soilType = :soil")
    List<Crop> findSuitableCrops(@Param("temp") Double temp, @Param("soil") String soil);
}
