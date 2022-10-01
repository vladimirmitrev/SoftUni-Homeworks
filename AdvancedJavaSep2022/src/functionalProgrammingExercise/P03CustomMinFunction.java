package functionalProgrammingExercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersList = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        //Function<int[], Integer> minNumberFunction = numberArr -> Arrays.stream(numberArr).min().getAsInt();

        Function<int[], Integer> minNumberFunction = arr -> Collections.min(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(minNumberFunction.apply(numbersList));


    }
}
