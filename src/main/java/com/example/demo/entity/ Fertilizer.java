package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String suitableCrop;
    private String soilType;

    public Fertilizer() {
    }

    public Fertilizer(String name, String suitableCrop, String soilType) {
        this.name = name;
        this.suitableCrop = suitableCrop;
        this.soilType = soilType;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
