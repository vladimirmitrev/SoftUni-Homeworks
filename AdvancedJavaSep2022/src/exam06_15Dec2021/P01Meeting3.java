package exam06_15Dec2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Meeting3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(males::push);
        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCount = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            if (males.peek() <= 0 || females.peek() <= 0 || males.peek() % 25 == 0 || females.peek() % 25 == 0) {
                extracted(males);
                extracted(females);
            } else {
                if (males.peek().equals(females.peek())) {
                    matchesCount++;
                    males.pop();
                } else {
                    males.push(males.pop() - 2);
                }
                females.poll();
            }
        }
        System.out.println("Matches: " + matchesCount);

        System.out.println(males.isEmpty() ? "Males left: none"
                : String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", "))));

        System.out.println(females.isEmpty() ? "Females left: none"
                : String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", "))));

    }

    private static void extracted(ArrayDeque<Integer> collection) {
        if (collection.peek() <= 0) {
            collection.pop();
        } else if (collection.peek() % 25 == 0) {
            collection.pop();
            collection.pop();
        }
    }
}
