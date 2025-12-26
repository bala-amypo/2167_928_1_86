package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crops")
    public ResponseEntity<?> addCrop(@RequestBody CropRequest req, Authentication auth) {
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) return ResponseEntity.status(403).build();

        Crop crop = Crop.builder()
                .name(req.getName())
                .suitablePHMin(req.getSuitablePHMin())
                .suitablePHMax(req.getSuitablePHMax())
                .requiredWater(req.getRequiredWater())
                .season(req.getSeason())
                .build();
        return ResponseEntity.ok(catalogService.addCrop(crop));
    }

    @PostMapping("/fertilizers")
    public ResponseEntity<?> addFertilizer(@RequestBody FertilizerRequest req, Authentication auth) {
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) return ResponseEntity.status(403).build();
        return ResponseEntity.ok(null); // Add service call here if needed
    }

    @GetMapping("/crops/search")
    public ResponseEntity<List<Crop>> findCrops(@RequestParam Double ph, @RequestParam Double water, @RequestParam String season) {
        return ResponseEntity.ok(catalogService.findSuitableCrops(ph, water, season));
    }

    @GetMapping("/fertilizers/search")
    public ResponseEntity<List<?>> findFerts(@RequestParam String cropName) {
        return ResponseEntity.ok(catalogService.findFertilizersForCrops(List.of(cropName)));
    }
}