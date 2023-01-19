package functionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String type = scanner.nextLine();

        int start = bounds[0];
        int end = bounds[1];

        System.out.println(IntStream.rangeClosed(start, end)
                .boxed()
                .filter(getPredicate(type))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static Predicate<Integer> getPredicate(String type) {
        if(type.equals("odd")) {
            return n -> n % 2 != 0;
        }
         return n -> n % 2 == 0;
    }
}
