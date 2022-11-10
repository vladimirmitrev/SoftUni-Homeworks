package exam06_15Dec2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Meeting2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(femalesQueue::offer);

        int totalCouples = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int maleValue = malesStack.peek();
            int femaleValue = femalesQueue.peek();

            if(maleValue <= 0) {
                malesStack.pop();
              //  continue;
            } else if(femaleValue <= 0) {
                femalesQueue.poll();
               // continue;
            } else if(maleValue % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
            } else if(femaleValue % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
            } else if (femaleValue == maleValue) {
                totalCouples++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                malesStack.pop();
                malesStack.push(maleValue - 2);
            }
        }
        System.out.printf("Matches: %d%n", totalCouples);

        String malesLeft = malesStack.isEmpty() ? "none" : malesStack.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Males left: " + malesLeft);

        String femalesLeft = femalesQueue.isEmpty() ? "none" : femalesQueue.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Females left: " + femalesLeft);


    }
}
