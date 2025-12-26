package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    default List<Fertilizer> findByCropName(String crop) {
        return findAll();
    }
}
