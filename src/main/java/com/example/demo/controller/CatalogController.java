package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.example.demo.dto.FertilizerRequest;

@RestController
public class CatalogController {

    @PostMapping("/fertilizers")
    public ResponseEntity<String> addFertilizer(@Valid @RequestBody FertilizerRequest fertilizerRequest) {
        // Add logic to save fertilizer to database
        return new ResponseEntity<>("Fertilizer added successfully: " + fertilizerRequest.getName(), HttpStatus.CREATED);
    }
}
