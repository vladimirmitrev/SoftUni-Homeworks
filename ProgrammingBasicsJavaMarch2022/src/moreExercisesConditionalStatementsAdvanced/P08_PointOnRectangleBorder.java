package moreExercisesConditionalStatementsAdvanced;

import java.util.Scanner;

public class P08_PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        if ((x > x1 && x < x2 && y > y1 && y < y2) || ((x < x1 || y < y1 || x >x2 || y > y2))) {
            System.out.println("Inside / Outside");
        } else {
            System.out.println("Border");
        }
    }
}
