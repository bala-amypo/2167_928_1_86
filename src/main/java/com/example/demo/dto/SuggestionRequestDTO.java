package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SuggestionRequestDTO {

    @NotBlank
    private String title;

    @NotNull
    private Double value;

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }
}
