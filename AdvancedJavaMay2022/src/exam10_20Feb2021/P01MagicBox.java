package exam10_20Feb2021;

import java.util.*;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(secondBoxStack::push);

        List<Integer> itemList = new ArrayList<>();


        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstValue = firstBoxQueue.peek();
            int secondValue = secondBoxStack.peek();
            int sum = firstValue + secondValue;

            if(sum % 2 == 0) {
                itemList.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.addLast(secondBoxStack.pop());
            }
        }
        if(firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        int totalItemSum = 0;

        for (Integer item : itemList) {
            totalItemSum += item;
        }
        if(totalItemSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", totalItemSum);
        } else {
            System.out.printf("Poor prey... Value: %d", totalItemSum);
        }
    }
}
