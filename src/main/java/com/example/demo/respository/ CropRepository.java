package com.example.demo.repository;

import com.example.demo.entity.Crop;
import java.util.List;

public interface CropRepository {
    void save(Crop crop);
    List<Crop> findAll();
}
