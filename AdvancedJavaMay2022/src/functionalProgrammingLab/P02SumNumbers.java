package functionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormatter = list -> "Count = " + list.size();

        String countOutput = countFormatter.apply(numbersList);

        Function<List<Integer>, Integer> sumAllElements = l -> l.stream().reduce(0, Integer::sum);

        Function<Integer, String> sumFormatter = s -> "Sum = " + s;

        int sum = sumAllElements.apply(numbersList);

        String sumOutput = sumFormatter.apply(sum);

        System.out.println(countOutput);
        System.out.println(sumOutput);
    }
}
