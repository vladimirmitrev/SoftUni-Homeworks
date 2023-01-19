package Exam12_Retake19Aug2020;

import java.util.*;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> rosesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(rosesStack::push);

        ArrayDeque<Integer> liliesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(liliesQueue::offer);

        int bouquetsCount = 0;

        List<Integer> flowersList = new ArrayList<>();

        while (!rosesStack.isEmpty() && !liliesQueue.isEmpty()) {
            int daffodilsValue = liliesQueue.peek();
            int tulipsValue = rosesStack.peek();
            int sum = daffodilsValue + tulipsValue;

            if(sum == 15) {
                bouquetsCount++;
                liliesQueue.poll();
                rosesStack.pop();
            } else if(sum > 15) {
                rosesStack.pop();
                rosesStack.push(tulipsValue - 2);
            } else {
                flowersList.add(liliesQueue.poll());
                flowersList.add(rosesStack.pop());
            }
        }
        int flowersLeft = 0;

        for (Integer integer : flowersList) {
            flowersLeft += integer;
        }
        bouquetsCount += (flowersLeft / 15);

        if(bouquetsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", bouquetsCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - bouquetsCount);
        }
    }
}
