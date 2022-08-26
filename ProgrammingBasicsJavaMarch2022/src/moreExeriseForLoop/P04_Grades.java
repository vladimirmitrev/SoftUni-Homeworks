package moreExeriseForLoop;

import java.util.Scanner;

public class P04_Grades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double examSum = 0;
        double examAverage = 0;
        double totalGrades = 0;
        double poorGrades = 0;
        double fairGrades = 0;
        double goodGrades = 0;
        double excellentGrades = 0;


        for (int i = 1; i <= n ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 2 && grade <= 2.99) {
                poorGrades++;
                examSum += grade;
            }
            if (grade >= 3 && grade <= 3.99) {
                fairGrades++;
                examSum += grade;
            }
            if (grade >= 4 && grade <= 4.99) {
                goodGrades++;
                examSum += grade;
            }
            if (grade >= 5) {
                excellentGrades++;
                examSum += grade;
            }
        }
        totalGrades = poorGrades + fairGrades + goodGrades + excellentGrades;
        examAverage = examSum / n;

        System.out.printf("Top students: %.2f%%%n", excellentGrades * 100 / n);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", goodGrades * 100 / n);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", fairGrades * 100 / n);
        System.out.printf("Fail: %.2f%%%n", poorGrades * 100 / n);
        System.out.printf("Average: %.2f", examAverage);
    }
}
