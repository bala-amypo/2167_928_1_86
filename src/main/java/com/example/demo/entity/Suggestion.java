package com.example.demo.entity;

public class Suggestion {
    private Long id;
    private Crop crop;
    private Fertilizer fertilizer;
    private Farm farm;

    public Suggestion() {}

    public Suggestion(Long id, Crop crop, Fertilizer fertilizer, Farm farm) {
        this.id = id;
        this.crop = crop;
        this.fertilizer = fertilizer;
        this.farm = farm;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Crop getCrop() { return crop; }
    public void setCrop(Crop crop) { this.crop = crop; }
    public Fertilizer getFertilizer() { return fertilizer; }
    public void setFertilizer(Fertilizer fertilizer) { this.fertilizer = fertilizer; }
    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }
}
