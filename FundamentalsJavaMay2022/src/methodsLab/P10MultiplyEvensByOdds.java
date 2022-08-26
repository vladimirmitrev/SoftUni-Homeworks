package methodsLab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(sumOfDigits(number));

    }

    public static int sumOfDigits (int number){
        int result = 0;
        int lastDigit = 0;
        int sumOfEvenDigits = 0;
        int sumOFOddDigits = 0;
        while (number != 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sumOfEvenDigits += lastDigit;
            } else {
                sumOFOddDigits += lastDigit;
            }
            number = number / 10;
        }
        result = sumOfEvenDigits * sumOFOddDigits;

        return result;
    }
}
