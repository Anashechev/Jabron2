import java.util.Scanner;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки широта/долгота:");
        double lat1 = scanner.nextDouble();
        double lon1 = scanner.nextDouble();

        System.out.println("Введите координаты второй точки широта/долгота:");
        double lat2 = scanner.nextDouble();
        double lon2 = scanner.nextDouble();

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");

        scanner.close();
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}