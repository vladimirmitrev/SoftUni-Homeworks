package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int numbersToPush = input[0];
        int numbersToPop = input[1];
        int searchingElement = input[2];

        int[] elements = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            stack.push(elements[i]);

        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            System.out.println("0");
        } else if(stack.contains(searchingElement)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
