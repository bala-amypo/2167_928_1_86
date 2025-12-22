package com.example.demo.controller;

import com.example.demo.entity.Suggestion;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService service;

    @PostMapping("/{farmId}")
    public Suggestion generate(@PathVariable Long farmId) {
        return service.generateSuggestion(farmId);
    }

    @GetMapping("/{id}")
    public Suggestion get(@PathVariable Long id) {
        return service.getSuggestion(id);
    }

    @GetMapping("/farm/{farmId}")
    public List<Suggestion> byFarm(@PathVariable Long farmId) {
        return service.getSuggestionsByFarm(farmId);
    }
}
