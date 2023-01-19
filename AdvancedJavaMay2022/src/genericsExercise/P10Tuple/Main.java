package genericsExercise.P10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String firstName = input[0];
        String lastName = input[1];
        String address = input[2];
        Tuple<String, String> stringTuple = new Tuple<>(firstName + " " + lastName, address);
        System.out.println(stringTuple);

        input = scanner.nextLine().split(" ");
        String name = input[0];
        int beerLiters = Integer.parseInt(input[1]);
        Tuple<String, Integer> integerTuple = new Tuple<>(name, beerLiters);
        System.out.println(integerTuple);

        input = scanner.nextLine().split(" ");
        int integerNum = Integer.parseInt(input[0]);
        double doubleNum = Double.parseDouble(input[1]);
        Tuple<Integer, Double> doubleTuple = new Tuple<>(integerNum, doubleNum);
        System.out.println(doubleTuple);

    }
}
