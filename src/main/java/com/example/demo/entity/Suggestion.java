package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recommendedCrop;

    @ManyToOne
    private Farm farm;

    public Suggestion() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRecommendedCrop() { return recommendedCrop; }
    public void setRecommendedCrop(String recommendedCrop) { this.recommendedCrop = recommendedCrop; }
    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }
}
