package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.exception.BadRequestException;

@Entity
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String npkRatio;

    private String recommendedForCrops; // comma-separated

    public Fertilizer() {}

    public Fertilizer(Long id, String name, String npkRatio, String recommendedForCrops) {
        this.id = id;
        this.name = name;
        this.npkRatio = npkRatio;
        this.recommendedForCrops = recommendedForCrops;
    }

    @PrePersist
    public void validate() {
        if (!npkRatio.matches("\\d+-\\d+-\\d+")) throw new BadRequestException("NPK");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNpkRatio() { return npkRatio; }
    public void setNpkRatio(String npkRatio) { this.npkRatio = npkRatio; }

    public String getRecommendedForCrops() { return recommendedForCrops; }
    public void setRecommendedForCrops(String recommendedForCrops) { this.recommendedForCrops = recommendedForCrops; }
}
