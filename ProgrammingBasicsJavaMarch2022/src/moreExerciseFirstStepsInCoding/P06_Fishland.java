package moreExerciseFirstStepsInCoding;

import java.util.Scanner;

public class P06_Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double spratPrice = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        double musselKg = Double.parseDouble(scanner.nextLine());

        double bonitoPrice = mackerelPrice * 1.60;
        double scadPrice = spratPrice * 1.80;
        double musselPrice =  7.50;
        double totalBonitoPrice = bonitoKg * bonitoPrice;
        double totalScadPrice = scadKg * scadPrice;
        double totalMusselPrice = musselKg * musselPrice;
        double totalPrice = totalBonitoPrice + totalScadPrice + totalMusselPrice;

        System.out.printf("%.2f", totalPrice);
    }
}
