package com.example.demo.entity;

public class Crop {
    private Long id;
    private String name;
    private Double minPH;
    private Double maxPH;
    private String season;

    public Crop() {}

    public Crop(Long id, String name, Double minPH, Double maxPH, String season) {
        this.id = id;
        this.name = name;
        this.minPH = minPH;
        this.maxPH = maxPH;
        this.season = season;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getMinPH() { return minPH; }
    public void setMinPH(Double minPH) { this.minPH = minPH; }
    public Double getMaxPH() { return maxPH; }
    public void setMaxPH(Double maxPH) { this.maxPH = maxPH; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}
