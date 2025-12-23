package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fertilizers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String npkRatio;

    private String recommendedForCrops; // CSV of crop names
}
