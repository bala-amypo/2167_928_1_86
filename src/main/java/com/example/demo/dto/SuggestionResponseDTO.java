package com.example.demo.dto;

public class SuggestionResponseDTO {

    private Long id;
    private String title;
    private Double value;

    public SuggestionResponseDTO() {}

    public SuggestionResponseDTO(Long id, String title, Double value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
}
