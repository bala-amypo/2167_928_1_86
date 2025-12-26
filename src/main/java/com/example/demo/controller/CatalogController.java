package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.CatalogService;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    private boolean isAdmin(Authentication auth) {
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    @PostMapping("/crop")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
        if (!isAdmin(auth)) return ResponseEntity.status(403).build();
        Crop c = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        return ResponseEntity.ok(catalogService.addCrop(c));
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        if (!isAdmin(auth)) return ResponseEntity.status(403).build();
        Fertilizer f = Fertilizer.builder()
                .name(req.getName())
                .npkRatio(req.getNpkRatio())
                .recommendedForCrops(req.getRecommendedForCrops())
                .build();
        return ResponseEntity.ok(catalogService.addFertilizer(f));
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<?> findCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {
        return ResponseEntity.ok(catalogService.findSuitableCrops(ph, water, season));
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<?> findFerts(@RequestParam String name) {
        return ResponseEntity.ok(catalogService.findFertilizersForCrops(java.util.List.of(name)));
    }
}
