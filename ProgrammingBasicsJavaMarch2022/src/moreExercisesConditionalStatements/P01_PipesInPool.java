package moreExercisesConditionalStatements;

import java.util.Scanner;

public class P01_PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poolVolume = Integer.parseInt(scanner.nextLine());
        int pipeOneDebit = Integer.parseInt(scanner.nextLine());
        int pipeTwoDebit = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double pipeOneInPool = pipeOneDebit * hours;
        double pipeTwoInPool = pipeTwoDebit * hours;
        double totalWaterIn = pipeOneInPool + pipeTwoInPool;
        double totalPercent = totalWaterIn * 100 / poolVolume;
        double pipeOnePercent = (pipeOneInPool * 100) / totalWaterIn;
        double pipeTwoPercent = (pipeTwoInPool * 100) / totalWaterIn;
        double overFlowWater = totalWaterIn - poolVolume;

        if (poolVolume >= totalWaterIn) {
            System.out.printf("The pool is %.2f%% full." +
                    " Pipe 1: %.2f%%. Pipe 2: %.2f%%.", totalPercent, pipeOnePercent, pipeTwoPercent);
        } else if (totalWaterIn >= poolVolume) {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overFlowWater );
        }

    }
}
