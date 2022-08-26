package whileLoopLab;

import java.util.Scanner;

public class Password_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String regPassword = scanner.nextLine();

        while (true) {
            String currentPass = scanner.nextLine();

            if (currentPass.equals(regPassword)) {
                break;
            }
        }
        System.out.printf("Welcome %s!", username);
    }
}
