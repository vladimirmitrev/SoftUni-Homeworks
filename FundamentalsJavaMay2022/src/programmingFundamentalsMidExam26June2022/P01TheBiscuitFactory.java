package programmingFundamentalsMidExam26June2022;

import java.util.Scanner;

public class P01TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfBiscuitPerWorker = Integer.parseInt(scanner.nextLine());
        int numberOfWorkers = Integer.parseInt(scanner.nextLine());
        int numberOfOtherFactory = Integer.parseInt(scanner.nextLine());

        double totalBiscuit = 0;

        int totalDays = 1;

        while (totalDays <= 30) {
            double totalBiscuitsDay = 0;
            totalBiscuitsDay = Math.floor(numberOfBiscuitPerWorker * numberOfWorkers);
            if (totalDays % 3 == 0) {
                totalBiscuitsDay = Math.floor(totalBiscuitsDay * 0.75);
                totalBiscuit += totalBiscuitsDay;
            } else {
                totalBiscuit += totalBiscuitsDay;
            }
            totalDays++;
        }
        double percentDifference = Math.abs(totalBiscuit - numberOfOtherFactory);
        double percentMore = percentDifference / numberOfOtherFactory * 100;
        // double percentLess = percentDifference / totalBiscuit * 100;
        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalBiscuit);
        if (totalBiscuit > numberOfOtherFactory) {
            System.out.printf("You produce %.2f percent more biscuits.", percentMore);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", percentMore);
        }

    }
}
