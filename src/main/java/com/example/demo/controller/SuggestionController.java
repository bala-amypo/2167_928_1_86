package com.example.demo.controller;

import com.example.demo.dto.SuggestionRequestDTO;
import com.example.demo.dto.SuggestionResponseDTO;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @GetMapping
    public List<SuggestionResponseDTO> getAll() {
        return suggestionRepository.findAll().stream()
                .map(s -> new SuggestionResponseDTO(s.getId(), s.getTitle(), s.getValue()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public SuggestionResponseDTO create(@Valid @RequestBody SuggestionRequestDTO dto) {
        Suggestion s = new Suggestion();
        s.setTitle(dto.getTitle());
        s.setValue(dto.getValue());
        Suggestion saved = suggestionRepository.save(s);
        return new SuggestionResponseDTO(saved.getId(), saved.getTitle(), saved.getValue());
    }
}
