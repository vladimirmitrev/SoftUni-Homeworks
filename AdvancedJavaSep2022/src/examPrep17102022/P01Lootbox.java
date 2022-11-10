package examPrep17102022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int collectItems = 0;

       while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
           int firstBoxValue = firstBoxQueue.peek();
           int secondBoxValue = secondBoxStack.pop();
           int sum = firstBoxValue + secondBoxValue;

           if(sum % 2 == 0) {
               firstBoxQueue.poll();
               collectItems += sum;
           } else {
               firstBoxQueue.offer(secondBoxValue);
           }
       }
       if(firstBoxQueue.isEmpty()) {
           System.out.println("First lootbox is empty");
       } else {
           System.out.println("Second lootbox is empty");
       }

       if (collectItems >= 100) {
           System.out.printf("Your loot was epic! Value: %d", collectItems);
       } else {
           System.out.printf("Your loot was poor... Value: %d", collectItems);
       }
    }
}
