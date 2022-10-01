package setsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        int firstSetSize = input[0];
        int secondSetSize = input[1];

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }
        for (int i = 0; i < secondSetSize; i++) {
                secondSet.add(scanner.nextLine());
        }
        firstSet.retainAll(secondSet);
        for (String element : firstSet) {
            System.out.print(element + " ");
        }

//        for (String element : firstSet) {
//            if(secondSet.contains(element)) {
//                System.out.print(element + " ");
//            }
//        }
    }
}
