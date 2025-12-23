package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserRequestDTO {
    @NotBlank
    private String email;  // replace old username

    @NotBlank
    private String password;
}
