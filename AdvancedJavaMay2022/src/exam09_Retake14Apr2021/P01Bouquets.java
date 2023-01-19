package exam09_Retake14Apr2021;

import java.util.*;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodilsQueue::offer);

        int bouquetsCount = 0;

        List<Integer> flowersList = new ArrayList<>();

       while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
                int daffodilsValue = daffodilsQueue.peek();
                int tulipsValue = tulipsStack.peek();
                int sum = daffodilsValue + tulipsValue;

                if(sum == 15) {
                    bouquetsCount++;
                    daffodilsQueue.poll();
                    tulipsStack.pop();
                } else if(sum > 15) {
                    tulipsStack.pop();
                    tulipsStack.push(tulipsValue - 2);
                } else {
                    flowersList.add(daffodilsQueue.poll());
                    flowersList.add(tulipsStack.pop());
                }
       }
       int flowersLeft = 0;

        for (Integer integer : flowersList) {
                    flowersLeft += integer;
        }
        bouquetsCount += (flowersLeft / 15);

        if(bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
        }

    }
}
