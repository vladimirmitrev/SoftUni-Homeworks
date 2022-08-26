package programming04FundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("Go Shopping!")) {
            String[] commandParts = commandLine.split(" ");
            String command = commandParts[0];


            switch (command) {
                case "Urgent":
                    String urgentItem = commandParts[1];
                    if (!shoppingList.contains(urgentItem)) {
                        shoppingList.add(0, urgentItem);
                    }
                    break;
                case "Unnecessary":
                    String unnecessaryItem = commandParts[1];
                    if (shoppingList.contains(unnecessaryItem)) {
                        shoppingList.remove(unnecessaryItem);
                    }
                    break;
                case "Correct":
                    String correctItem = commandParts[1];
                    String newItem = commandParts[2];
                    if (shoppingList.contains(correctItem)) {
                        int index = shoppingList.indexOf(correctItem);
                        shoppingList.add(index, newItem);
                        shoppingList.remove(correctItem);
                    }
                    break;
                case "Rearrange":
                    String rearrangeItem = commandParts[1];
                    if (shoppingList.contains(rearrangeItem)) {
                        shoppingList.remove(rearrangeItem);
                        shoppingList.add(rearrangeItem);
                    }
                    break;

            }
            commandLine = scanner.nextLine();
        }
        //System.out.println(String.join(", ", shoppingList));

        for (int i = 0; i <= shoppingList.size() - 1; i++) {
            if (i != shoppingList.size() - 1) {
                System.out.print(shoppingList.get(i) + ", ");
            } else {
                System.out.print(shoppingList.get(i));
            }
        }
    }
}
