package bacicSyntaxMoreExercises;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int clicks = Integer.parseInt(scanner.nextLine());

            String message = "";

        for (int i = 0; i < clicks; i++) {
            String digits = scanner.nextLine();
            int digitLength = digits.length();
            int digit = digits.charAt(0);
            int offset = (digit - 2)  * 3;

            if (digit == 0) {
                message += (char)(digit + 32);
                continue;
            }
            if (digit == 8 || digit == 9) {
                offset++;
            }
            int letterIndex = offset + digitLength - 1;
            message += (char) (letterIndex + 'a');
        }
        System.out.println(message);
    }
}
