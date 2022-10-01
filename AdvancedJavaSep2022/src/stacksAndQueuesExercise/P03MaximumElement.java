package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int command = input[0];
            switch (command) {
                case 1:
                    elements.push(input[1]);
                    break;
                case 2:
                    elements.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(elements));
                    break;
            }
        }
    }
}
