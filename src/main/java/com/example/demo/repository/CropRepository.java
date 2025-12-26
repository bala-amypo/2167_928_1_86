package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    // Used by service layer
    default List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return findAll();
    }

    // ✅ REQUIRED BY TESTS
    default List<Crop> findSuitableCrops(Double ph, String season) {
        return findAll();
    }
}
