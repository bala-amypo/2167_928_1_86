package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/{farmId}")
    public Suggestion generate(@PathVariable Long farmId) {
        return suggestionService.generateSuggestion(farmId);
    }

    // REQUIRED BY TESTS
    public Suggestion getSuggestion(long id) {
        return suggestionService.getSuggestion(id);
    }

    @GetMapping("/farm/{farmId}")
    public List<Suggestion> list(@PathVariable Long farmId) {
        return suggestionService.getSuggestionsByFarm(farmId);
    }
}
