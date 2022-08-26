package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustingFactor = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        int startPower = power;

        while (power >= distance) {
            power -= distance;
            counter++;

            if (power == startPower * 0.5) {
                if (exhaustingFactor > 0) {
                    power = power / exhaustingFactor;
                }
            }
        }
        System.out.println(power);
        System.out.println(counter);
    }
}
