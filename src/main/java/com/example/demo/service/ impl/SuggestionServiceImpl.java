package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.SuggestionServiceImpl;

public class SuggestionServiceImpl extends SuggestionServiceImpl {

    public SuggestionServiceImpl(FarmService farmService,
                                 CatalogService catalogService,
                                 SuggestionRepository suggestionRepository) {
        super(farmService, catalogService, suggestionRepository);
    }
}
