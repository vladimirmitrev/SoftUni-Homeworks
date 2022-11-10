package polymorphismExercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] animalTokens = input.split("\\s+");

            if("Cat".equals(animalTokens[0])) {
                String breed = animalTokens[4];
                Animal cat = new Cat(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3], breed);
                animals.add(cat);
            } else if ("Mouse".equals(animalTokens[0])) {
                Animal mouse = new Mouse(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(mouse);
            } else if ("Tiger".equals(animalTokens[0])) {
                Animal tiger = new Tiger(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(tiger);
            } else if ("Zebra".equals(animalTokens[0])) {
                Animal zebra = new Zebra(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(zebra);
            }

            String[] foodTokens = input.split("\\s+");

            if ("Vegetable".equals(foodTokens[0])) {
                Food vegetable = new Vegetable(Integer.parseInt(foodTokens[1]));
                foods.add(vegetable);

            } else if ("Meat".equals(foodTokens[0])) {
                Food meat = new Meat(Integer.parseInt(foodTokens[1]));
                foods.add(meat);
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);
            animal.makeSound();
            animal.eat(food);
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }
}
