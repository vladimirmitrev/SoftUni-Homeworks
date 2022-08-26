package firsStepsInCodingExersise;

import java.util.Scanner;

public class VacationBooksList_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesBook = Integer.parseInt(scanner.nextLine());

        int pagesHour = Integer.parseInt(scanner.nextLine());

        int days = Integer.parseInt(scanner.nextLine());

        int holeBook = pagesBook / pagesHour;

        int allBook = holeBook / days;

        System.out.printf("%d", allBook);


    }
}
