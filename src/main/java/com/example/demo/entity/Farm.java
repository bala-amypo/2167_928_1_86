package com.example.demo.entity;

import jakarta.persistence.*; // Change from javax to jakarta
import lombok.*;

@Entity
@Table(name = "farms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    private String name;
    private Double soilPH;
    private Double waterLevel;
    private String season;
}