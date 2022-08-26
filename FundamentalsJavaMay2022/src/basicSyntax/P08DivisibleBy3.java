package basicSyntax;

import java.util.Scanner;

public class P08DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i <+ 100 ; i += 3) {
            System.out.println(i);
        }
    }
}
