package programming01FundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        int countMoves = 0;
        boolean end = false;
        while (!commandLine.equals("end")) {
            String[] command = commandLine.split(" ");
            countMoves++;
            String firstIndex = command[0];
            String secondIndex = command[1];
            int index1 = Integer.parseInt(command[0]);
            int index2 = Integer.parseInt(command[1]);
            int middleIndex = elements.size() / 2;


            if (index1 != index2 && index1 >= 0 && index1 <= elements.size() - 1
                    && index2 >= 0 && index2 <= elements.size() -1) {

                String currentElement1 = elements.get(index1);
                String currentElement2 = elements.get(index2);
                if (currentElement1.equals(currentElement2)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", currentElement1);
                    if (index1 > index2) {
                        elements.remove(index1);
                        elements.remove(index2);
                    } else {
                        elements.remove(index2);
                        elements.remove(index1);
                    }
                    if (elements.size() == 0) {
                        System.out.printf("You have won in %d turns!", countMoves);
                        break;
                    }
                } else if (!Objects.equals(elements.get(index1), elements.get(index2))) {
                    System.out.println("Try again!");
                }
            } else {
                elements.add(middleIndex, "-" + countMoves + "a");
                elements.add(middleIndex, "-" + countMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            commandLine = scanner.nextLine();
        }
        if (commandLine.equals("end")) {
            System.out.println("Sorry you lose :(");
            for (String element : elements) {
                System.out.print(element + " ");
            }
        }
    }
}

