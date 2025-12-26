package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String npkRatio;
    private String recommendedForCrops;
}
