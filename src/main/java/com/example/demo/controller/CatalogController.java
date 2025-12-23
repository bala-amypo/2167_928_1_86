package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    private final List<Crop> crops = new ArrayList<>();
    private final List<Fertilizer> fertilizers = new ArrayList<>();

    public void addCrop(CropRequest req) {
        Crop crop = new Crop(null, req.getName(), req.getSuitablePHMin(), req.getSuitablePHMax(), req.getRequiredWater(), "ALL");
        crops.add(crop);
    }

    public void addFertilizer(FertilizerRequest req) {
        Fertilizer fertilizer = new Fertilizer(null, req.getName(), req.getNpkRatio(), req.getRecommendedForCrops());
        fertilizers.add(fertilizer);
    }
}
