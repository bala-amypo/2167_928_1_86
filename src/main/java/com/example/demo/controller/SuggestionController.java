package com.example.demo.controller;

import com.example.demo.service.SuggestionService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService service;

    public SuggestionController(SuggestionService service) {
        this.service = service;
    }

    @PostMapping("/{farmId}")
    public ResponseEntity<?> generate(@PathVariable Long farmId) {
        return ResponseEntity.ok(service.generateSuggestion(farmId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSuggestion(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSuggestion(id));
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<?> getByFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(service.getSuggestionsByFarm(farmId));
    }
}
