package interfacesAndAbstractionExercise.birthdayCelebrations;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] inputParts = input.split("\\s+");

            String typeToCreate = inputParts[0];

            switch (typeToCreate) {
                case "Citizen":
                    String citizenName = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String birthDate = inputParts[4];
                    Birthable citizen = new Citizen(citizenName, age, id, birthDate);
                    birthables.add(citizen);
                    break;
                case "Robot":
                    // TODO: 04-Nov-22 Create Robots!
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBirthDate = inputParts[2];
                    Birthable pet = new Pet(petName, petBirthDate);
                    birthables.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        birthables.stream()
                .filter(e -> e.getBirthDate().endsWith(year))
                .forEach(e -> System.out.println(e.getBirthDate()));

//        birthables.stream()
//                .map(Birthable::getBirthDate)
//                .filter(birthDate -> birthDate.endsWith(year))
//                .forEach(System.out::println);


//        for (Birthable birthable : birthables) {
//            if(birthable.getBirthDate().endsWith(year)) {
//                System.out.println(birthable.getBirthDate());
//            }
//        }
    }


}
