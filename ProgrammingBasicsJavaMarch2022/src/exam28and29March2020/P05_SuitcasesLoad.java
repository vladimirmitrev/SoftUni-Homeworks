package exam28and29March2020;

import java.util.Scanner;

public class P05_SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalVolume = Double.parseDouble(scanner.nextLine());

        String command = scanner.nextLine();

        int suitcaseCount = 0;
        boolean noMore = false;

        while (!command.equals("End")) {
            double currentSuitcase = Double.parseDouble(command);
            suitcaseCount++;
            if (suitcaseCount % 3 == 0) {
                currentSuitcase = currentSuitcase * 1.10;
            }
            totalVolume = totalVolume - currentSuitcase;

            if (totalVolume <= 0) {
                suitcaseCount--;
                noMore = true;
                break;
            }

            command = scanner.nextLine();

        }
        if (noMore) {
            System.out.printf("No more space!%n");
            System.out.printf("Statistic: %d suitcases loaded.", suitcaseCount);
        } else {
            System.out.printf("Congratulations! All suitcases are loaded!%n");
            System.out.printf("Statistic: %d suitcases loaded.", suitcaseCount);
        }
    }
}
