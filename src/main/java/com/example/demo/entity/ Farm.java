package com.example.demo.entity;

public class Farm {
    private Long id;
    private String name;
    private Double soilPH;
    private String season;
    private User owner;

    public Farm() {}

    public Farm(Long id, String name, Double soilPH, String season, User owner) {
        this.id = id;
        this.name = name;
        this.soilPH = soilPH;
        this.season = season;
        this.owner = owner;
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
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
