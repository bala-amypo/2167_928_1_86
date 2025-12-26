package com.example.demo.entity;

import jakarta.persistence.*; // Change from javax to jakarta
import lombok.*;

@Entity
@Table(name = "fertilizers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
}