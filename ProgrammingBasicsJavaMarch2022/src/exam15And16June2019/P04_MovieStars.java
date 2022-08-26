package exam15And16June2019;

import java.util.Scanner;

public class P04_MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String name = scanner.nextLine();
        double salaryOut = 0;

        while (!name.equals("ACTION")) {

            if (name.length() <= 15 && name.length() > 0) {
                double salary = Double.parseDouble(scanner.nextLine());
                salaryOut = salary;
            }  else {
                salaryOut = budget * 0.20;
            }

            if (budget < salaryOut) {
                break;
            }
            budget -= salaryOut;
            salaryOut = 0;

            name = scanner.nextLine();
        }
        if (budget >= salaryOut) {
            System.out.printf("We are left with %.2f leva.", budget);
        } else {
            System.out.printf("We need %.2f leva for our actors." ,Math.abs(salaryOut - budget));
        }
    }
}
