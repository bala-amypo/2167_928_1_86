package com.example.demo.repository;

import com.example.demo.entity.Farm;
import java.util.List;

public interface FarmRepository {
    void save(Farm farm);
    List<Farm> findAll();
}
