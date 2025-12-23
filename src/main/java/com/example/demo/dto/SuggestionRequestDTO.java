package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionRequestDTO {
    @NotBlank
    private String message;

    @NotNull
    private Long farmId;
}
