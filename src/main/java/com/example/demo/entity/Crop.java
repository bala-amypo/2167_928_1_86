package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "crops")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double suitablePHMin;
    private Double suitablePHMax;
    private String soilType; // optional
}
