package basicSyntax;

import java.util.Scanner;

public class P11MultiplicationTable20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int startNum = Integer.parseInt(scanner.nextLine());


        if (startNum > 10) {
            int sum = num * startNum;
            System.out.printf("%d X %d = %d%n", num, startNum, sum);

        }
        for (int i = startNum; i <= 10; i++) {
            int sum = i * num;
            System.out.printf("%d X %d = %d%n", num, i, sum);

        }
    }
}
