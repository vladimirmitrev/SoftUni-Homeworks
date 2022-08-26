package methodsExercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);

        printCharactersBetweenInput(one, two);

    }

    private static void printCharactersBetweenInput (char one, char two) {

        int startChar = Math.min(one, two);
        int endChar = Math.max(one, two);

        for (int i = startChar + 1 ; i < endChar ; i++) {
            char currentChar = (char) i;
            System.out.print(currentChar + " ");
        }
        }
    }

