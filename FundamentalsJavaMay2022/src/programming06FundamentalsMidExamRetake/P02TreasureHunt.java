package programming06FundamentalsMidExamRetake;

import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Yohoho!")) {
            String[] command = commandLine.split(" ");

            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i < command.length; i++) {
                        boolean isThere = false;
                        for (int j = 0; j < treasureChest.length ; j++) {
                            if(command[i].equals(treasureChest[j])) {
                                isThere = true;
                                break;
                            }
                        }
                        if (!isThere) {
                            String newChest = command[i] + " " + String.join(" ", treasureChest);
                            treasureChest = newChest.split(" ");
                        }
                    }
                    break;
                case "Drop":
                    int position = Integer.parseInt(command[1]);

                    if(position >= 0 && position <= treasureChest.length - 1) {
                        String dropItem = treasureChest[position];
                        for (int i = position; i < treasureChest.length - 1 ; i++) {
                            treasureChest[i] = treasureChest[i + 1];

                        }
                        treasureChest[treasureChest.length - 1] = dropItem;

                    } else {
                        break;
                    }
                    break;

                case "Steal":
                    int numberOfSteals = Integer.parseInt(command[1]);
                    if (numberOfSteals >= 0 && numberOfSteals < treasureChest.length) {
                        for (int i = 0; i < numberOfSteals ; i++) {
                            System.out.print(treasureChest[treasureChest.length - numberOfSteals + i]);
                            if (i != numberOfSteals - 1) {
                                System.out.print(", ");
                            }
                        }
                        String[] tempChest = new String[treasureChest.length - numberOfSteals];
                        for (int i = 0; i < tempChest.length ; i++) {
                            tempChest[i] = treasureChest[i];
                        }
                        treasureChest = tempChest;
                    } else if (numberOfSteals >= 0) {
                        for (int i = 0; i < treasureChest.length ; i++) {
                            System.out.print(treasureChest[i]);
                            if(i != treasureChest.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        treasureChest = new String[0];
                    }
                    System.out.println();
                    break;
            }
            commandLine = scanner.nextLine();
        }
        String treasureCount = String.join("", treasureChest);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length() ; i++) {
            charCounter++;
        }
        double averageTreasure = (1.0 * charCounter) / treasureChest.length;
        if (charCounter > 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
