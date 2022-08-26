package methodsExercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int finalResult = (sumOfFirstAndSecondNum(firstNum,secondNum)) - thirdNum;

        System.out.println(finalResult);

    }

    private static int sumOfFirstAndSecondNum (int firstNum, int secondNum) {

        int result = firstNum + secondNum;

        return result;
    }
}
