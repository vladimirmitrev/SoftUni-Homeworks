package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = number -> {
            int minElement = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= minElement) {
                    minElement = list.get(i);
                    minIndex = i;
                }
            } return minIndex;
        };
        System.out.println(minElementIndex.apply(list));

//        Function<List<Integer>, Integer> minElementIndex2 = number -> {
//            int minElement = number.stream().mapToInt(e -> e).min().getAsInt();
//            return list.lastIndexOf(minElement);
//        };
//        System.out.println(minElementIndex2.apply(list));
    }
}
