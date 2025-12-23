package com.example.demo.dto;

public class CropRequest {
    private String name;
    private double suitablePHMin;
    private double suitablePHMax;
    private double requiredWater;

    public CropRequest() {}

    public CropRequest(String name, double suitablePHMin, double suitablePHMax, double requiredWater) {
        this.name = name;
        this.suitablePHMin = suitablePHMin;
        this.suitablePHMax = suitablePHMax;
        this.requiredWater = requiredWater;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSuitablePHMin() { return suitablePHMin; }
    public void setSuitablePHMin(double suitablePHMin) { this.suitablePHMin = suitablePHMin; }
    public double getSuitablePHMax() { return suitablePHMax; }
    public void setSuitablePHMax(double suitablePHMax) { this.suitablePHMax = suitablePHMax; }
    public double getRequiredWater() { return requiredWater; }
    public void setRequiredWater(double requiredWater) { this.requiredWater = requiredWater; }
}
