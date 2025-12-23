package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;

    @ManyToOne
    private User owner;

    public Farm() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }
    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
