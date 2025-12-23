package com.example.demo.service.impl;

import com.example.demo.dto.SuggestionRequestDTO;
import com.example.demo.dto.SuggestionResponseDTO;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    public SuggestionServiceImpl(SuggestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public SuggestionResponseDTO generateSuggestion(SuggestionRequestDTO requestDTO) {
        Suggestion suggestion = new Suggestion();
        suggestion.setTitle(requestDTO.getTitle());
        suggestion.setDescription(requestDTO.getDescription());
        suggestion.setFarmId(requestDTO.getFarmId());

        Suggestion saved = repository.save(suggestion);
        return new SuggestionResponseDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getFarmId());
    }

    @Override
    public SuggestionResponseDTO getSuggestion(Long id) {
        Suggestion suggestion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suggestion not found"));
        return new SuggestionResponseDTO(suggestion.getId(), suggestion.getTitle(), suggestion.getDescription(), suggestion.getFarmId());
    }

    @Override
    public List<SuggestionResponseDTO> getSuggestionsByFarm(Long farmId) {
        return repository.findByFarmId(farmId)
                .stream()
                .map(s -> new SuggestionResponseDTO(s.getId(), s.getTitle(), s.getDescription(), s.getFarmId()))
                .collect(Collectors.toList());
    }
}
