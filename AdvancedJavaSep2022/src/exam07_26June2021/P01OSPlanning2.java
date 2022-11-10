package exam07_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(taskStack::push);

        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(threadQueue::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        int taskValue = taskStack.peek();
        int threadValue = threadQueue.peek();

        while (taskValue != taskToBeKilled) {

            if(threadValue >= taskValue) {
                taskStack.pop();
            }
            threadQueue.poll();

            taskValue = taskStack.peek();
            threadValue = threadQueue.peek();

        }
        System.out.printf("Thread with value %d killed task %d%n", threadValue, taskToBeKilled);

        String threadLeft = threadQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(threadLeft);
    }
}
