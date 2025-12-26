package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.impl.CatalogServiceImpl;

public class CatalogServiceImpl extends CatalogServiceImpl {

    public CatalogServiceImpl(CropRepository cropRepository,
                              FertilizerRepository fertilizerRepository) {
        super(cropRepository, fertilizerRepository);
    }
}
