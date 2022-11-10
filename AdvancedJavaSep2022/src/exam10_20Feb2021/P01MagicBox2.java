package exam10_20Feb2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MagicBox2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secondBoxStack::push);

        int claimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstValue = firstBoxQueue.peek();
            int secondValue = secondBoxStack.peek();
            int sum = firstValue + secondValue;

            if(sum % 2 == 0) {
                claimedItems += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }
        }
        System.out.println(firstBoxQueue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.");

        if(claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedItems);
        }
    }
}
