package programming02FundamentalsMidExam02;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());

        int sum = 0;

        for (int number : numbersList) {
            sum += number;
        }
        double averageSum = sum * 1.0 / numbersList.size();

        List<Integer> top5Integers = new ArrayList<>();

        for (int currentNum : numbersList) {
            if (currentNum > averageSum) {
                top5Integers.add(currentNum);
            }
        }
        if (top5Integers.isEmpty()) {
            System.out.println("No");

        } else if (top5Integers.size() < 5) {
            for (int number : top5Integers) {

                System.out.printf("%d ", number);
            }
        } else {
            top5Integers = top5Integers.stream().limit(5).collect(Collectors.toList());

            for (int number : top5Integers) {

                System.out.printf("%d ", number);
            }
        }
    }
}
