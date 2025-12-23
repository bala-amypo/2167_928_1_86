package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.util.ValidationUtil;

@Entity
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    private String name;

    private Double soilPH;

    private Double waterLevel;

    private String season;

    public Farm() {}

    public Farm(Long id, User owner, String name, Double soilPH, Double waterLevel, String season) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
    }

    @PrePersist
    public void validate() {
        if (soilPH < 3 || soilPH > 10) throw new IllegalArgumentException("pH");
        if (!ValidationUtil.validSeason(season)) throw new IllegalArgumentException("Invalid season");
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }

    public Double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(Double waterLevel) { this.waterLevel = waterLevel; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}
