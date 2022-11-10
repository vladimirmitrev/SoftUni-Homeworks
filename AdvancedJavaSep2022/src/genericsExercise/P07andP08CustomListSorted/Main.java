package genericsExercise.P07andP08CustomListSorted;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();


        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            switch (command) {
                case "Add":
                    String elementToAdd = commandParts[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandParts[1]);
                    customList.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementsToFind = commandParts[1];
                    System.out.println(customList.contains(elementsToFind));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex = Integer.parseInt(commandParts[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elements = commandParts[1];
                    System.out.println(customList.countGreater(elements));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command");
            }
            input = scanner.nextLine();
        }
    }
}
