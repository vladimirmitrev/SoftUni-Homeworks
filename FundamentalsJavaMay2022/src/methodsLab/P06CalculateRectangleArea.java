package methodsLab;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        double area = calculatedArea(width, length);

        System.out.printf("%.0f", area);
    }
    public static double calculatedArea(double width, double length) {
        return width * length;
    }
}
