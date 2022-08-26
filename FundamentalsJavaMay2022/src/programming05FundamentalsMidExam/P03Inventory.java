package programming05FundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventoryList = Arrays.stream(scanner.nextLine()
                                         .split(", "))
                                         .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Craft!")) {
            String[] commandParts = commandLine.split(" - ");
            String command = commandParts[0];

            switch (command) {

                case "Collect":
                    String collectItem = commandParts[1];
                    if (!inventoryList.contains(collectItem)) {
                        inventoryList.add(collectItem);
                    }
                    break;
                case "Drop":
                    String dropItem = commandParts[1];
                    if (inventoryList.contains(dropItem)) {
                        inventoryList.remove(dropItem);
                    }
                    break;
                case "Combine Items":
                    String[] combineItems = commandParts[1].split(":");
                    String oldItem = combineItems[0];
                    String newItem = combineItems[1];
                    if (inventoryList.contains(oldItem)) {
                        int index = inventoryList.indexOf(oldItem);
                        inventoryList.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    String renewItem = commandParts[1];
                    if (inventoryList.contains(renewItem)) {
                        inventoryList.remove(renewItem);
                        inventoryList.add(renewItem);
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }

        System.out.println(String.join(", ", inventoryList));
    }
}
