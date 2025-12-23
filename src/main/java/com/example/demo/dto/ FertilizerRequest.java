package com.example.demo.dto;

public class FertilizerRequest {

    private String name;
    private String suitableCrop;
    private String soilType;

    public FertilizerRequest() {
    }

    public String getName() {
        return name;
    }

    public String getSuitableCrop() {
        return suitableCrop;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuitableCrop(String suitableCrop) {
        this.suitableCrop = suitableCrop;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}
