package com.example.demo.entity;

public class Farm {
    private Long id;
    private String name;
    private double soilPH;
    private double waterLevel;
    private String season;
    private User owner;

    public Farm() {}

    public Farm(Long id, String name, double soilPH, double waterLevel, String season, User owner) {
        this.id = id;
        this.name = name;
        this.soilPH = soilPH;
        this.waterLevel = waterLevel;
        this.season = season;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSoilPH() { return soilPH; }
    public void setSoilPH(double soilPH) { this.soilPH = soilPH; }
    public double getWaterLevel() { return waterLevel; }
    public void setWaterLevel(double waterLevel) { this.waterLevel = waterLevel; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
