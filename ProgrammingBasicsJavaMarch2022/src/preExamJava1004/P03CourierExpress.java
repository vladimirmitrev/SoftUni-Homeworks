package preExamJava1004;

import java.util.Scanner;

public class P03CourierExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double packageKg = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        int distanceKm = Integer.parseInt(scanner.nextLine());

        double price = 0;
        double expressPrice1 = distanceKm * (packageKg * 0.80 * 0.03);
        double expressPrice2 = distanceKm * (packageKg * 0.40 * 0.05);
        double expressPrice3 = distanceKm * (packageKg * 0.05 * 0.10);
        double expressPrice4 = distanceKm * (packageKg * 0.02 * 0.15);
        double expressPrice5 = distanceKm * (packageKg * 0.01 * 0.20);


        switch (type) {
            case "standard":
                if (packageKg > 1) {
                    price = distanceKm * 0.03;
                }
                if (packageKg >= 1 && packageKg < 10) {
                    price = distanceKm * 0.05;
                }
                if (packageKg >= 10 && packageKg < 40) {
                    price = distanceKm * 0.10;
                }
                if (packageKg >= 40 && packageKg < 90) {
                    price = distanceKm * 0.15;
                }
                if (packageKg >= 90 && packageKg < 150) {
                    price = distanceKm * 0.20;
                }
                break;
            case "express":
                if (packageKg < 1) {
                    price = (distanceKm * 0.03) + expressPrice1;
                }
                if (packageKg >= 1 && packageKg < 10) {
                    price = (distanceKm * 0.05) + expressPrice2;
                }
                if (packageKg >= 10 && packageKg < 40) {
                    price = (distanceKm * 0.10) + expressPrice3;
                }
                if (packageKg >= 40 && packageKg < 90) {
                    price = (distanceKm * 0.15) + expressPrice4;
                }
                if (packageKg >= 90 && packageKg <= 150) {
                    price = (distanceKm * 0.20) + expressPrice5;

                    break;
                }


        }
        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.",packageKg, price);
    }
}
