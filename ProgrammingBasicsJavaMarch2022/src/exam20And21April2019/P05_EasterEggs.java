package exam20And21April2019;

import java.util.Scanner;

public class P05_EasterEggs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsCount = Integer.parseInt(scanner.nextLine());

        int redCount = 0;
        int orangeCount = 0;
        int blueCount = 0;
        int greenCount = 0;

        for (int i = 1; i <= eggsCount ; i++) {
            String color = scanner.nextLine();

            switch (color) {
                case "red":
                    redCount++;
                    break;
                case "orange":
                    orangeCount++;
                    break;
                case "blue":
                    blueCount++;
                    break;
                case "green":
                    greenCount++;
                    break;
            }

        }
        int maxEggs = redCount;
        String maxColor = "red";

        if (orangeCount > maxEggs) {
            maxEggs = orangeCount;
            maxColor = "orange";
        }
        if (blueCount > maxEggs) {
            maxEggs = blueCount;
            maxColor = "blue";
        }
        if (greenCount > maxEggs) {
            maxEggs = greenCount;
            maxColor = "green";
        }
        System.out.printf("Red eggs: %d%n", redCount);
        System.out.printf("Orange eggs: %d%n", orangeCount);
        System.out.printf("Blue eggs: %d%n", blueCount);
        System.out.printf("Green eggs: %d%n", greenCount);
        System.out.printf("Max eggs: %d -> %s", maxEggs, maxColor);

    }
}
