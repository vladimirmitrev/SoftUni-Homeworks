package selfTesting;

import java.util.Scanner;

public class InchToCm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double centimeter = Double.parseDouble(scanner.nextLine());

        double inch = centimeter * 2.54;

        System.out.println(inch);

    }
}
