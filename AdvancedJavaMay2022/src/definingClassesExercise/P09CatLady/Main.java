package definingClassesExercise.P09CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Cat> catMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String catBreed = tokens[0];
            String catName = tokens[1];
            Cat cat = null;

                    switch (catBreed) {
                        case "StreetExtraordinaire":
                            double decibels = Double.parseDouble(tokens[2]);
                            cat = new StreetExtraordinaire(catName, decibels);
                            break;

                        case "Siamese":
                            double earSize = Double.parseDouble(tokens[2]);
                            cat = new Siamese(catName, earSize);

                            break;
                        case "Cymric":
                            double furLength = Double.parseDouble(tokens[2]);
                            cat = new Cymric(catName, furLength);
                            break;

                    }
                    catMap.put(catName, cat);

            input = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        System.out.println(catMap.get(nameToPrint).toString());
    }
}
