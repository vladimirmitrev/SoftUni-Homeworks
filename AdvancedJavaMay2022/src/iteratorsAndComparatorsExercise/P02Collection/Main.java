package iteratorsAndComparatorsExercise.P02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Collection collection = null;
        while(!input.equals("END")) {
            String[] commandParts = input.split(" ");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Create":
                    if(commandParts.length > 1) {
                        collection = new Collection(Arrays.copyOfRange(commandParts, 1 , commandParts.length));
                    } else {
                        collection = new Collection();
                    }
                    break;
                case "Move":
                    System.out.println(collection.move());
                    break;
                case "HasNext":
                    System.out.println(collection.hasNext());
                    break;
                case "Print":
                    try {
                        collection.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "PrintAll":
                    for (String element : collection) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
