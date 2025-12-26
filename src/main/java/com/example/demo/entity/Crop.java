package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Crop {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;

    // Add manual getters if Lombok is not generating them
    public String getName() { return name; }
    public Double getSuitablePHMin() { return suitablePHMin; }
    public Double getSuitablePHMax() { return suitablePHMax; }
    public String getSeason() { return season; }
}