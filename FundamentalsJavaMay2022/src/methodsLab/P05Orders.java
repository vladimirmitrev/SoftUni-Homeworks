package methodsLab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int qty = Integer.parseInt(scanner.nextLine());

        sumOfProducts(product, qty);

    }
    public static void sumOfProducts(String product, int qty) {
        double result = 0.00;

        switch (product) {
            case "coffee":
                result = qty * 1.50;
                break;
            case "water":
                result = qty * 1.0;
                break;
            case "coke":
                result = qty * 1.40;
                break;
            case "snacks":
                result = qty * 2.00;
                break;
            default:
                break;
        }
        System.out.printf("%.2f", result);
    }
}
