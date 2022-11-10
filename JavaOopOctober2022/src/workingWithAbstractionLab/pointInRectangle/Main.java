package workingWithAbstractionLab.pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeftPoint = new Point(bottomLeftX, bottomLeftY);
        Point topRightPoint = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        int coordinatesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= coordinatesCount; i++) {
            int[] coordinatesToSearch = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int x = coordinatesToSearch[0];
            int y = coordinatesToSearch[1];
            Point searchedPoint = new Point(x, y);

            System.out.println(rectangle.contains(searchedPoint));

        }
    }
}
