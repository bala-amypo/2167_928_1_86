package com.example.demo.dto;

public class SuggestionResponseDTO {

    private Long id;
    private String title;
    private String description;

    public SuggestionResponseDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
