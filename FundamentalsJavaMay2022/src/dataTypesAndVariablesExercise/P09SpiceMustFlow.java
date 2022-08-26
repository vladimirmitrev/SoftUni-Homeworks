package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalSpice = 0;
        while (startingYield >= 100) {
            int spice = startingYield - 26;
            totalSpice += spice;
            days++;
            startingYield -= 10;

        }
        System.out.println(days);
        if (totalSpice >= 26) {
            totalSpice -= 26;
        }
        System.out.println(totalSpice);
    }
}
