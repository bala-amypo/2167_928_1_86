package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequestDTO;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {
    private final SuggestionRepository suggestionRepository;

    public SuggestionController(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    @PostMapping("/suggestions")
    public ResponseEntity<Suggestion> createSuggestion(@RequestBody @Valid SuggestionRequestDTO dto) {
        Suggestion suggestion = new Suggestion();
        suggestion.setMessage(dto.getMessage());
        suggestion.setFarmId(dto.getFarmId());
        Suggestion saved = suggestionRepository.save(suggestion);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/suggestions/{farmId}")
    public ResponseEntity<List<Suggestion>> getSuggestions(@PathVariable Long farmId) {
        List<Suggestion> list = suggestionRepository.findByFarmId(farmId);
        return ResponseEntity.ok(list);
    }
}
