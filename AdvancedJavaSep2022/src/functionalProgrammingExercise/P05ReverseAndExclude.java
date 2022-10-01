package functionalProgrammingExercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = number -> number % n == 0;

        Consumer<Integer> printer = number -> System.out.printf("%d ", number);

        numberList.removeIf(predicate);

        Collections.reverse(numberList);

        numberList.forEach(printer);

       // numberList.forEach(number -> System.out.print(number + " "));

    }

}
