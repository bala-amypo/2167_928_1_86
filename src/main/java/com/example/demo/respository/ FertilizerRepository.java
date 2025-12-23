package com.example.demo.repository;

import com.example.demo.entity.Fertilizer;
import java.util.List;

public interface FertilizerRepository {
    void save(Fertilizer fertilizer);
    List<Fertilizer> findAll();
}
