package programming03FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWinError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays
                        .stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String commandLine = scanner.nextLine();
        int totalShot = 0;

        while (!commandLine.equals("End")) {
            String[] command = commandLine.split(" ");
            int index = Integer.parseInt(command[0]);

            if (index >= 0 && index < targets.length) {
                for (int i = 0; i < targets.length ; i++) {
                    int element = targets[i];
                    if (i != index && element != -1) {
                        targets[index] = -1;
                        totalShot++;

                        for (int j = 0; j < targets.length ; j++) {
                            int target = targets[j];

                            if(target != -1) {
                                if (target > element) {
                                    targets[j] -= element;
                                } else if (target <= element) {
                                    targets[j] += element;
                                }
                            }
                        }
                    }
                }

            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", totalShot);
        for (int i = 0; i < targets.length ; i++) {
            System.out.print(targets[i] + " ");
        }

    }
}
