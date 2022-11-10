package exam06_15Dec2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(maleStack::push);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(femaleQueue::offer);

        int matchesCount = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int femaleValue = femaleQueue.peek();
            int maleValue = maleStack.peek();

            if (femaleValue != 0 && femaleValue % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
            } else if (maleValue != 0 && maleValue % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
            } else if (femaleValue <= 0) {
                femaleQueue.poll();

            } else if (maleValue <= 0) {
                maleStack.pop();

            } else if (femaleValue == maleValue) {
                femaleQueue.poll();
                maleStack.pop();
                matchesCount++;
            } else {
                femaleQueue.poll();
                maleStack.pop();
                maleStack.push(maleValue - 2);
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);

        String maleLeft = !maleStack.isEmpty() ? maleStack.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")) : "none";

        System.out.println("Males left: " + maleLeft);

        String femaleLeft = !femaleQueue.isEmpty() ? femaleQueue.stream()
                .map(String::valueOf).collect(Collectors.joining(", ")) : "none";

        System.out.println("Females left: " + femaleLeft);

    }
}
