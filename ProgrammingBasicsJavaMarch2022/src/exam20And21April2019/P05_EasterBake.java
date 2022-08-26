package exam20And21April2019;

import java.util.Scanner;

public class P05_EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int breadCount = Integer.parseInt(scanner.nextLine());

        double totalSugar = 0;
        double totalFlour = 0;

        int maxUsedSugar = 0;
        int maxUsedFlour = 0;

        for (int i = 1; i <= breadCount ; i++) {
            int currentSugar = Integer.parseInt(scanner.nextLine());
            int currentFlour = Integer.parseInt(scanner.nextLine());

            totalSugar += currentSugar;
            totalFlour += currentFlour;

            if (currentSugar > maxUsedSugar) {
                maxUsedSugar = currentSugar;
            }
            if (currentFlour > maxUsedFlour) {
                maxUsedFlour = currentFlour;
            }

        }
        double packetsSugar = Math.ceil(totalSugar / 950);
        double packetsFlour = Math.ceil(totalFlour / 750);

        System.out.printf("Sugar: %.0f%n", packetsSugar);
        System.out.printf("Flour: %.0f%n", packetsFlour);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxUsedFlour, maxUsedSugar);

    }
}
