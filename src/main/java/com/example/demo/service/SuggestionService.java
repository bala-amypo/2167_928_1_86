package com.example.demo.service;

import com.example.demo.dto.SuggestionRequestDTO;
import com.example.demo.dto.SuggestionResponseDTO;

import java.util.List;

public interface SuggestionService {
    SuggestionResponseDTO generateSuggestion(SuggestionRequestDTO requestDTO);
    SuggestionResponseDTO getSuggestion(Long id);
    List<SuggestionResponseDTO> getSuggestionsByFarm(Long farmId);
}
