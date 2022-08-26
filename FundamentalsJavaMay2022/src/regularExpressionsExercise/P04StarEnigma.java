package regularExpressionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int messages = Integer.parseInt(scanner.nextLine());

        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiers>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= messages; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = decrypting(encryptedMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);
            if(matcher.find()) {

            String planetName = matcher.group("planetName");
            int population = Integer.parseInt(matcher.group("population"));
            String attackType = matcher.group("attackType");
            int soldiers = Integer.parseInt(matcher.group("soldiers"));

            if (attackType.equals("A")) {
                attackedPlanets.add(planetName);
            } else if (attackType.equals("D")) {
                destroyedPlanets.add(planetName);
            }
         }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));

    }

    private static String decrypting(String encryptedMessage) {

        StringBuilder decryptedWord = new StringBuilder();
        int countLetters = countedLetters(encryptedMessage);
        for (char symbol : encryptedMessage.toCharArray()) {
            char decryptedChar = (char)(symbol - countLetters);
            decryptedWord.append(decryptedChar);
        }
        return decryptedWord.toString();
    }

    private static int countedLetters(String encryptedMessage) {
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }

        }
        return count;
    }
}

