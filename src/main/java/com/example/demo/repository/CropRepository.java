package com.example.demo.repository;

import com.example.demo.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface CropRepository extends JpaRepository<Crop, Long> {
    default List<Crop> findSuitableCrops(Double ph, Double water, String season) {
        return findAll();
    }
}
