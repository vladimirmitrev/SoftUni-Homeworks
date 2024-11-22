package org.softuni.recursionandcombinatorialproblemsexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class P04TowerOfHanoi {
    public static StringBuilder output = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 1;
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis(); // Record start time

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1 ; i--) {
            source.push(i);
        }

        printRods();
        solve(disk, source, destination, spare);
        System.out.println(output.toString());

        long endTime = System.currentTimeMillis(); // Record end time
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            output.append("Step #").append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());
            printRods();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    public static void printRods() {
        output.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                        formatRod(source), formatRod(destination), formatRod(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        StringBuilder result = new StringBuilder();

        for (Iterator<Integer> it = stack.descendingIterator(); it.hasNext(); ) {
            Integer disk = it.next();
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(disk);
        }

        return result.toString();
    }
//    private static String formatRod(Deque<Integer> stack) {
//        StringBuilder result = new StringBuilder();
//
//        // Convert Deque to an array (list works as well)
//        Integer[] arr = new Integer[stack.size()];
//        stack.toArray(arr);
//
//        // Iterate the array in reverse order using a for loop
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (result.length() > 0) {
//                result.append(", ");
//            }
//            result.append(arr[i]);
//        }
//
//        return result.toString();
//    }

//    Slower iteration
//
//    private static String formatRod(Deque<Integer> stack) {
//        return stack.stream()
//                .sorted(Comparator.reverseOrder())
//                .map(String::valueOf)
//                .collect(Collectors.joining(", "));
//    }

}
