package com.example.demo.util;

import java.util.Arrays;
import java.util.List;

public class ValidationUtil {
    private static final List<String> VALID_SEASONS = Arrays.asList("Kharif", "Rabi", "Zaid");

    public static boolean validSeason(String season) {
        return season != null && VALID_SEASONS.contains(season);
    }

    public static boolean validPH(Double ph) {
        // Required for t42: pH must be between 3.0 and 10.0
        return ph != null && ph >= 3.0 && ph <= 10.0;
    }
}