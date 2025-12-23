package com.example.demo.service;

import com.example.demo.entity.Farm;
import java.util.List;

public interface FarmService {
    List<Farm> getAllFarms();
    Farm saveFarm(Farm farm);
}
