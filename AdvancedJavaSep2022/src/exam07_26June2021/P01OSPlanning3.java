package exam07_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int stop = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty() && tasks.peek() != stop) {
            int threadsValue = threads.poll() , tasksValue = tasks.pop();
            if (threadsValue < tasksValue) {
                tasks.push(tasksValue);
            }
        }
        System.out.printf("Thread with value %d killed task %d%n", threads.peek(), stop);
        System.out.printf("%s", threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}