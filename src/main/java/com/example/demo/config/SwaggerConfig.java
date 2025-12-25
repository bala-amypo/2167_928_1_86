package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // 🔴 REQUIRED BY TESTS
    public OpenAPI api() {
        return new OpenAPI();
    }

    @Bean
    public OpenAPI openAPI() {
        return api();
    }
}
