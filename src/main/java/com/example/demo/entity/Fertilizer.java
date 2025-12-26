package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Fertilizer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String npkRatio;
    private String recommendedForCrops; // Expected by t27 as a CSV string
}