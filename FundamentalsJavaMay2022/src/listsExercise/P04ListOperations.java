package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if(command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                numbers.add(numberToAdd);
            } else if (command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(command.split(" ")[1]);
                int indexToInsert = Integer.parseInt(command.split(" ")[2]);
                if(isValidIndex(indexToInsert, numbers.size())) {
                    numbers.add(indexToInsert, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Remove")) {
                int indexToRemove = Integer.parseInt(command.split(" ")[1]);
                if(isValidIndex(indexToRemove, numbers.size())) {
                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Shift left ")) {
                int leftCount = Integer.parseInt(command.split(" ")[2]);
                for (int count = 1; count <= leftCount ; count++) {
                    int firstNumber = numbers.get(0);
                    numbers.add(firstNumber);
                    numbers.remove(0);
                }
            } else if (command.contains("Shift right")) {
                int rightCount = Integer.parseInt(command.split(" ")[2]);
                for (int count = 1; count <= rightCount ; count++) {
                    int lastNumber = numbers.get(numbers.size() - 1);
                    numbers.add(0, lastNumber);
                    numbers.remove(numbers.size() - 1);

                }

            }

            command = scanner.nextLine();
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }

    public static boolean isValidIndex (int index, int sizeOfList) {
        return index >= 0 && index <= sizeOfList - 1;
    }
}
