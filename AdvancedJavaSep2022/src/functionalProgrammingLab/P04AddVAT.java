package functionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Double> printer = price -> System.out.printf("%.2f%n", price);

        UnaryOperator<Double> addVat = value -> value * 1.20;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(printer);
                //.forEach(price -> System.out.printf("%.2f%n", price));

    }
}
