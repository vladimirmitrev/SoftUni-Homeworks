package moreExeriseForLoop;

import java.util.Scanner;

public class P06_Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        double electricity = 0;
        double months = 0;

        for (int i = 1; i <=n ; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            electricity += input;
            months++;
        }
        double water = months * 20;
        double internet = months * 15;
        double others = (water + internet + electricity) * 1.2;
        double totalPayments = water + internet + electricity + others;

        System.out.printf("Electricity: %.2f lv%n", electricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", internet);
        System.out.printf("Other: %.2f lv%n", others);
        System.out.printf("Average: %.2f lv", totalPayments / months);
    }
}
