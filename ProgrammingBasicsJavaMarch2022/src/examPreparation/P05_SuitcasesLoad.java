package examPreparation;

import java.util.Scanner;

public class P05_SuitcasesLoad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalVolume = Double.parseDouble(scanner.nextLine());

        double copyTotalVolume = totalVolume;
        boolean isFull = false;
        int suitCaseCount = 0;
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            double volumeSuitcase = Double.parseDouble(input);
            suitCaseCount++;
            if (suitCaseCount % 3 == 0) {
                volumeSuitcase = volumeSuitcase * 1.10;
            }
            copyTotalVolume = copyTotalVolume - volumeSuitcase;
            if (copyTotalVolume <= 0) {
                isFull = true;
                suitCaseCount--;
                break;
            }
            input = scanner.nextLine();
        } if (isFull) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitCaseCount);
    }
}
