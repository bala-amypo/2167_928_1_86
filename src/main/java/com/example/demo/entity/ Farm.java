package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long ownerId;
    private String location;

    public Farm() {}

    public Farm(Long id, String name, Long ownerId, String location) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.location = location;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
