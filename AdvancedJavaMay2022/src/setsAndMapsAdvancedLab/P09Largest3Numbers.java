package setsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        List<Integer> nums = Arrays
//                .stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .sorted((n1, n2) -> n2.compareTo(n1))
//                .limit(3)
//                .collect(Collectors.toList());
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }

        System.out.println(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));


    }
}
