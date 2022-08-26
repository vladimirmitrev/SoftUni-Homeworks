package moreExercisesNestedLoops;

import java.util.Scanner;

public class P05_ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int menCount = Integer.parseInt(scanner.nextLine());
        int womenCount = Integer.parseInt(scanner.nextLine());
        int tableCount = Integer.parseInt(scanner.nextLine());

        int tableTaken = 0;
        boolean allTablesTaken = false;

        for (int menNum = 1; menNum <= menCount ; menNum++) {
            for (int womenNum = 1; womenNum <= womenCount ; womenNum++) {
                if (tableCount == tableTaken) {
                    allTablesTaken = true;
                    break;
                } else {
                    System.out.printf("(%d <-> %d) ", menNum, womenNum);
                    tableTaken++;
                }
            }
            if (allTablesTaken) {
                break;
            }
        }
    }
}
