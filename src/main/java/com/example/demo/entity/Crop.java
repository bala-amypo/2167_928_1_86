package com.example.demo.entity;

import jakarta.persistence.*; // Change from javax to jakarta
import lombok.*;

@Entity
@Table(name = "crops")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double suitablePHMin;
    private Double suitablePHMax;
    private Double requiredWater;
    private String season;
}