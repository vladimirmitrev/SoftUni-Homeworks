package exam09_Retake14Apr2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodilsQueue::offer);

        int leftFlowers = 0;

        int totalBouquets = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int daffodilsValue = daffodilsQueue.poll();
            int tulipsValue = tulipsStack.pop();
            int sum = tulipsValue + daffodilsValue;

            if(sum == 15) {
                totalBouquets++;
            } else if(sum > 15) {
                daffodilsQueue.addFirst(daffodilsValue);
                tulipsStack.push(tulipsValue - 2);
            } else {
                leftFlowers += sum;
            }
        }
        totalBouquets += (leftFlowers / 15);

        if(totalBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", totalBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - totalBouquets);
        }

    }
}
