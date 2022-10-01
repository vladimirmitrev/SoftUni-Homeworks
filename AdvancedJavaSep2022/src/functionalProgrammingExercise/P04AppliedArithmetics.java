package functionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction = list -> list.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = list -> list.stream().map(el -> el - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = list -> list.stream().map(el -> el * 2).collect(Collectors.toList());
        Consumer<Integer> print = list -> System.out.print(list + " ");
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numberList = addFunction.apply(numberList);
                    break;
                case "subtract":
                    numberList = subtractFunction.apply(numberList);
                    break;
                case "multiply":
                    numberList = multiplyFunction.apply(numberList);
                    break;
                case "print":
                    numberList.forEach(print);
                    System.out.println();
                    break;
                default:
                    System.out.println("UNAVAILABLE COMMAND");
            }
            input = scanner.nextLine();
        }
    }
}
