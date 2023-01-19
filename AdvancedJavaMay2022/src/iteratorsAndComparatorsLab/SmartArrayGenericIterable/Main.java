package iteratorsAndComparatorsLab.SmartArrayGenericIterable;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        SmartArray<Integer> numbers = new SmartArray<>();

        SmartArray<String> strings = new SmartArray<>();

        IntStream.rangeClosed(1, 5000)
                .forEach(numbers::add);

        IntStream.rangeClosed(1, 4987).forEach(i -> numbers.remove(0));

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
}
