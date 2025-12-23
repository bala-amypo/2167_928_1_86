package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double soilPH;
    private String season;

    // Default constructor
    public Farm() {}

    // Parameterized constructor
    public Farm(Long id, String name, Double soilPH, String season) {
        this.id = id;
        this.name = name;
        this.soilPH = soilPH;
        this.season = season;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSoilPH() { return soilPH; }
    public void setSoilPH(Double soilPH) { this.soilPH = soilPH; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}
