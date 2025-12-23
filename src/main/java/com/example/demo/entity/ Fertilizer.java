package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String suitableCrop;
    private String soilType;

    public Fertilizer() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSuitableCrop() { return suitableCrop; }
    public void setSuitableCrop(String suitableCrop) { this.suitableCrop = suitableCrop; }
    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }
}
