package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequestDTO;
import com.example.demo.dto.SuggestionResponseDTO;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/suggestions")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService service;

    @PostMapping
    public SuggestionResponseDTO generate(@Valid @RequestBody SuggestionRequestDTO requestDTO) {
        return service.generateSuggestion(requestDTO);
    }

    @GetMapping("/{id}")
    public SuggestionResponseDTO get(@PathVariable Long id) {
        return service.getSuggestion(id);
    }

    @GetMapping("/farm/{farmId}")
    public List<SuggestionResponseDTO> byFarm(@PathVariable Long farmId) {
        return service.getSuggestionsByFarm(farmId);
    }
}
