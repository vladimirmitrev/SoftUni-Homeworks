package methodsExercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int numberThree = Integer.parseInt(scanner.nextLine());

        smallestNumber(numberOne, numberTwo, numberThree);

    }

    public static void smallestNumber(int one, int two, int three) {
        if (one < two && one < three) {
            System.out.println(one);
        } else if (two < one && two < three ) {
            System.out.println(two);
        } else {
            System.out.println(three);
        }

    }
}
