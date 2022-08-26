package programming06FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipList = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShipList = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maximumHealth = Integer.parseInt(scanner.nextLine());
        String commandLine = scanner.nextLine();
        boolean isSink = false;
        boolean isStalemate = false;
        int pirateSum = 0;
        int warshipSum = 0;

        while (!commandLine.equals("Retire")) {

            String[] commandParts = commandLine.split(" ");
            String command = commandParts[0];

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(commandParts[1]);
                    int damage = Integer.parseInt(commandParts[2]);
                    if (index >= 0 && index <= warShipList.size() - 1) {
                    int currentHealth = warShipList.get(index);
                    currentHealth = currentHealth - damage;
                    warShipList.set(index, currentHealth);
                    if (currentHealth <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isSink = true;
                    }
                    }
                break;
                case "Defend":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    int damageToPirates = Integer.parseInt(commandParts[3]);
                    if (startIndex >= 0 && startIndex <= pirateShipList.size() - 1
                            && endIndex >= 0 && endIndex <= pirateShipList.size() - 1) {
                        for (int i = startIndex; i <= endIndex ; i++) {
                            int currentHealthPirate = pirateShipList.get(i);
                            currentHealthPirate = currentHealthPirate - damageToPirates;
                            pirateShipList.set(i, currentHealthPirate);
                            if (currentHealthPirate <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isSink = true;
                                break;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(commandParts[1]);
                    int repairHealth= Integer.parseInt(commandParts[2]);
                    if (repairIndex >= 0 && repairIndex <= pirateShipList.size() - 1) {
                        int currentRepairHealth = pirateShipList.get(repairIndex);
                        repairHealth = repairHealth + currentRepairHealth;
                        if (repairHealth > maximumHealth) {
                            repairHealth = maximumHealth;
                        }
                        pirateShipList.set(repairIndex, repairHealth);
                    }
                    break;
                case "Status":
                    int sectionCount = 0;
                    for (int i = 0; i <= pirateShipList.size() - 1 ; i++) {
                        int section = pirateShipList.get(i);
                        if (section < (maximumHealth * 0.2)) {
                            sectionCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", sectionCount);
                    break;

            }
            if (isSink) {
                break;
            }
            commandLine = scanner.nextLine();
        }
        if (commandLine.equals("Retire")) {
            isStalemate = true;
        }
        for (int pirate : pirateShipList) {
            pirateSum += pirate;
        }
        for (int warship : warShipList) {
            warshipSum += warship;
        }
        if (isStalemate) {
            System.out.printf("Pirate ship status: %d%n", pirateSum);
            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }
}
