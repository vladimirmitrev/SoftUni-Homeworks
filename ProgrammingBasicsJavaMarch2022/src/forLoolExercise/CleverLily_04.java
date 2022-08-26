package forLoolExercise;

import java.util.Scanner;

public class CleverLily_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washerPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int toysCount = 0;

        double money = 0;
        double allMoney = 0;
        int brother = 0;

        for (int i = 1; i <= age ; i++) {

            if (i % 2 == 0) {
                money = money + 10;
                allMoney = allMoney + money;
                brother++;

            } else {
                toysCount++;
            }
        }
        double toySum = toyPrice * toysCount;
        double totalMoney = allMoney - brother + toySum;
        double diff = Math.abs(washerPrice - totalMoney);
        if (totalMoney >= washerPrice) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}