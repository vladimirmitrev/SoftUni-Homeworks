package preExamJava1004;

import java.util.Scanner;

public class P04_GrandpaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double liters = 0;
        double degrees = 0;
        double totalLiters = 0;
        double averageDegrees = 0;
        double allDegrees = 0;
        double sumDegreesAndLiters = 0;

        String message = "";

        for (int i = 1; i <= n ; i++) {
            liters = Double.parseDouble(scanner.nextLine());
            degrees = Double.parseDouble(scanner.nextLine());

            totalLiters = totalLiters + liters;
            sumDegreesAndLiters = liters * degrees;
            allDegrees = allDegrees + sumDegreesAndLiters;



            }
        averageDegrees = allDegrees / totalLiters;

         if (averageDegrees < 38) {
            message = "Not good, you should baking!";

        } else if (averageDegrees >= 38 && averageDegrees <= 42) {
            message = "Super!";

        } else {
            message = "Dilution with distilled water!";
        }
        System.out.printf("Liter: %.2f%n", totalLiters);
        System.out.printf("Degrees: %.2f%n", averageDegrees);
        System.out.printf("%s", message);
    }
}
