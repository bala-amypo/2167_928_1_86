package com.example.demo.util;

import java.util.List;

public class ValidationUtil {

    private static final List<String> SEASONS =
            List.of("Kharif", "Rabi", "Summer");

    public static boolean validSeason(String season) {
        return SEASONS.contains(season);
    }
}
