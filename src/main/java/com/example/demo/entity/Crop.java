package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String season;

    public Crop() {
    }

    public Crop(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
