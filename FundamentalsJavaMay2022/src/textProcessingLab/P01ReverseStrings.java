package textProcessingLab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(!input.equals("end")) {
            String reversed = "";
            for (int i = input.length() - 1; i >= 0 ; i--) {
                char symbol = input.charAt(i);
                reversed = reversed + symbol;
            }
            System.out.printf("%s = %s%n", input, reversed);
            input = scanner.nextLine();
        }
    }
}
