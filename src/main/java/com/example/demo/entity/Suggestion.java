package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suggestedCrops;
    private String suggestedFertilizers;
    private LocalDateTime createdAt;

    @ManyToOne
    private Farm farm;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}