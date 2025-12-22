package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
}
