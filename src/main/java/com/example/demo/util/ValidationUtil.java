public class ValidationUtil {

    public static boolean validSeason(String season) {
        return List.of("Kharif", "Rabi", "Summer").contains(season);
    }
}
