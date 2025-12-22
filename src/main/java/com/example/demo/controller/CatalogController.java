package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    private void checkAdmin(Authentication auth) {
        if (auth.getAuthorities().stream()
                .noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
            throw new RuntimeException("Forbidden");
    }

    @PostMapping("/crop")
    @ResponseStatus(HttpStatus.CREATED)
    public Crop addCrop(@RequestBody CropRequest req, Authentication auth) {

        checkAdmin(auth);

        return catalogService.addCrop(
                Crop.builder()
                        .name(req.getName())
                        .suitablePHMin(req.getSuitablePHMin())
                        .suitablePHMax(req.getSuitablePHMax())
                        .requiredWater(req.getRequiredWater())
                        .season(req.getSeason())
                        .build()
        );
    }

    @PostMapping("/fertilizer")
    @ResponseStatus(HttpStatus.CREATED)
    public Fertilizer addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {

        checkAdmin(auth);

        return catalogService.addFertilizer(
                Fertilizer.builder()
                        .name(req.getName())
                        .npkRatio(req.getNpkRatio())
                        .recommendedForCrops(req.getRecommendedForCrops())
                        .build()
        );
    }

    @GetMapping("/crops/suitable")
    public List<Crop> suitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return catalogService.findSuitableCrops(ph, water, season);
    }

    @GetMapping("/fertilizers/by-crop")
    public List<Fertilizer> fertilizers(@RequestParam String name) {
        return catalogService.findFertilizersForCrops(List.of(name));
    }
}
