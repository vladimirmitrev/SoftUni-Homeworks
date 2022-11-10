package examPreparation022022.p01FlowerWreaths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int wreaths = 0;
        int otherFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int rose = rosesQueue.poll();
            int lily = liliesStack.pop();

            int sum = rose + lily;

            while (sum > 15) {
                lily -= 2;
                sum = rose + lily;
            }

            if(sum == 15) {
                wreaths++;
            } else {
                otherFlowers += sum;
            }

        }
        int flowersLeft = otherFlowers / 15;
        wreaths += flowersLeft;

        if(wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
