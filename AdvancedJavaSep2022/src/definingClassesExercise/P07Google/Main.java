package definingClassesExercise.P07Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> personMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];

            if(!personMap.containsKey(personName)) {
                Person newPerson = new Person(personName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                personMap.put(personName, newPerson);
            }

            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(personName).getPokemonList().add(pokemon);

                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirth = tokens[3];
                    Parent parent = new Parent(parentName, parentBirth);
                    personMap.get(personName).getParentList().add(parent);

                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirth = tokens[3];
                    Children children = new Children(childName, childBirth);

                    personMap.get(personName).getChildrenList().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    Car car = new Car(carModel, carSpeed);
                    personMap.get(personName).setCar(car);

                    break;
            }

            input = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();
        personMap.get(nameToPrint).printFormat();

    }
}

