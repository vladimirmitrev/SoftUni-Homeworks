package exam07_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasksStack::push);

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(threadsQueue::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        boolean killed = false;
        int taskKilled = 0;
        int threadKiller = 0;


        while (!killed) {
            int threadValue = threadsQueue.peek();
            int tasksValue = tasksStack.peek();

            if (tasksValue == taskToBeKilled) {
                taskKilled = tasksValue;
                threadKiller = threadValue;
                killed = true;
                break;
            } else if (threadValue >= tasksValue) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threadKiller, taskKilled);

        for (Integer integer : threadsQueue) {
            System.out.print(integer + " ");
        }
    }
}
