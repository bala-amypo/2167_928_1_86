package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

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