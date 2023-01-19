package genericsLab.SmartArrayGeneric;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        SmartArray<Integer> numbers = new SmartArray<>();

        SmartArray<String> strings = new SmartArray<>();

        IntStream.rangeClosed(1, 5000)
                .forEach(numbers::add);

        IntStream.rangeClosed(1, 4999).forEach(i -> numbers.remove(0));

        numbers.forEach(System.out::println);




    }
}
