package com.example.demo.util;

import java.util.List;

public class ValidationUtil {
    public static boolean validSeason(String s) {
        return List.of("Kharif", "Rabi", "Summer").contains(s);
    }
}
