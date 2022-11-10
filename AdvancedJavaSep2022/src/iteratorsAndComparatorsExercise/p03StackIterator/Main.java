package iteratorsAndComparatorsExercise.p03StackIterator;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Stack myStack = new Stack();



        while (!input.equals("END")) {
            String[] commandParts = input.split(" ");
            if(commandParts[0].equals("Pop")) {
               try {
                   myStack.pop();
                } catch (IllegalStateException ex) {
                   System.out.println(ex.getMessage());
               }

            } else {
                for (int i = 1; i < commandParts.length; i++) {
                    myStack.push(i);
                }
            }

            input = scanner.nextLine();
        }

        for (Integer integer : myStack) {
            System.out.println(integer);
        }
        for (Integer integer : myStack) {
            System.out.println(integer);
        }
    }
}
