package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FertilizerRequest {

    @NotBlank(message = "Fertilizer name is required")
    private String name;

    @NotNull(message = "Nitrogen value is required")
    private Double nitrogen;

    @NotNull(message = "Phosphorus value is required")
    private Double phosphorus;

    @NotNull(message = "Potassium value is required")
    private Double potassium;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getNitrogen() { return nitrogen; }
    public void setNitrogen(Double nitrogen) { this.nitrogen = nitrogen; }

    public Double getPhosphorus() { return phosphorus; }
    public void setPhosphorus(Double phosphorus) { this.phosphorus = phosphorus; }

    public Double getPotassium() { return potassium; }
    public void setPotassium(Double potassium) { this.potassium = potassium; }
}
