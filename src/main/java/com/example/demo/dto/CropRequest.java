package com.example.demo.dto;

public class CropRequest {

    private String name;
    private String season;

    public CropRequest() {
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
