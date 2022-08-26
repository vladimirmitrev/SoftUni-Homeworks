package arraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        for (int i = 0; i < input.length - 1 ; i++) {

            for (int j = 0; j < input.length - 1 ; j++) {

                input[j] = input[j] + input[j + 1];

            }
            
        }
        System.out.println(input[0]);

    }
}
