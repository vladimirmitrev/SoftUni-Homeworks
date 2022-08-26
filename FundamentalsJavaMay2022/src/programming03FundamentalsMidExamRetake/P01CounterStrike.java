package programming03FundamentalsMidExamRetake;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startEnergy = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        int currentEnergy = startEnergy;
        int wonCount = 0;
        boolean won = false;

        while (!command.equals("End of battle")) {
            int currentDistance = Integer.parseInt(command);
            if (currentEnergy >= currentDistance) {
                wonCount++;
                currentEnergy -= currentDistance;
                if (wonCount % 3 == 0) {
                    currentEnergy += wonCount;
                }
                won = true;
            } else {
                won = false;
                break;
            }

            command = scanner.nextLine();
        }
        if (won) {
            System.out.printf("Won battles: %d. Energy left: %d", wonCount, currentEnergy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonCount, currentEnergy);
        }
    }
}
