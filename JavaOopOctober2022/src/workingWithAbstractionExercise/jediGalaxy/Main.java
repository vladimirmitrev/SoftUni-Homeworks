package workingWithAbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = readPositions(scanner);
        int rows = size[0];
        int cols = size[1];

        Field field = new Field(rows, cols);

        String command = scanner.nextLine();

        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {

            Jedi jedi = new Jedi(Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray());
            int[] evilPosition = readPositions(scanner);
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            Galaxy galaxy = new Galaxy(field, jedi);

            galaxy.moveEvilPower(evilRow, evilCol);

            starsCollected += galaxy.moveJedi();

            command = scanner.nextLine();
        }
        System.out.println(starsCollected);

    }

    private static int[] readPositions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }


}
