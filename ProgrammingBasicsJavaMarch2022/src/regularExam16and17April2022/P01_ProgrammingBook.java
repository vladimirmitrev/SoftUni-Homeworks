package regularExam16and17April2022;

import java.util.Scanner;

public class P01_ProgrammingBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerPage = Double.parseDouble(scanner.nextLine());
        double priceFace = Double.parseDouble(scanner.nextLine());
        int discountForPaper = Integer.parseInt(scanner.nextLine());
        double priceForDesigner = Double.parseDouble(scanner.nextLine());
        int percentFromTotalPrice = Integer.parseInt(scanner.nextLine());

        double firstPrice = (pricePerPage * 899) + (priceFace * 2);
        double secondPrice = firstPrice - (firstPrice * discountForPaper / 100 );
        double thirdPrice = secondPrice + priceForDesigner;
        double finalPrice = thirdPrice - ( thirdPrice * percentFromTotalPrice / 100);

        System.out.printf("Avtonom should pay %.2f BGN.", finalPrice);

    }
}
