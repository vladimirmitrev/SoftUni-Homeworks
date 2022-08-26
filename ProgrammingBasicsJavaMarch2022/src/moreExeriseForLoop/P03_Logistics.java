package moreExeriseForLoop;

import java.util.Scanner;

public class P03_Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tons = 0;
        double bus = 0;
        double truck = 0;
        double train = 0;
        double totalTonsSum = 0;

        for (int i = 1; i <= n ; i++) {

            tons = Integer.parseInt(scanner.nextLine());

            if (tons <= 3) {
                bus = bus + tons;
            }
            if (tons >= 4 && tons <= 11) {
                truck = truck + tons;

            }
            if (tons >= 12) {
                train = train + tons;
            }
            totalTonsSum = totalTonsSum + tons;
        }


        double totalTons = bus + truck + train;
        double average = (bus * 200 + truck * 175 + train * 120) / totalTons;

        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n", bus / totalTons * 100);
        System.out.printf("%.2f%%%n", truck / totalTons * 100);
        System.out.printf("%.2f%%", train / totalTons * 100);
    }
}
