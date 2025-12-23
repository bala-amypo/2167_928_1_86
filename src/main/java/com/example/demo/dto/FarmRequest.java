package com.example.demo.dto;

public class FarmRequest {

    private String crop;
    private String soilType;

    public FarmRequest() {
    }

    public String getCrop() {
        return crop;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}
