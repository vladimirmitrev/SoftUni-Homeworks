package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientsService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientsService ingredientsService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientsService ingredientsService) {
        this.shampooService = shampooService;
        this.ingredientsService = ingredientsService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Todo Run this AdvqueryingApplication.java for initializing the database

        //Todo Insert data from "src/main/shampoo-company-insert.sql" in database

        //Todo Uncomment problem number and run the code from AdvqueryingApplication.java

//        P01SelectShampoosBySize(scanner);

//        P02SelectShampoosBySizeOrLabel(scanner);

//        P03SelectShampoosByPrice(scanner);

//        P04SelectIngredientsByName(scanner);

//        P05SelectIngredientsByNames(scanner);

//        P06CountShampoosByPrice(scanner);

//        P07SelectShampoosByIngredients(scanner);

//        P08SelectShampoosByIngredientsCount(scanner);

//        P09DeleteIngredientsByName(scanner);

//        P10UpdateIngredientsByPercent(scanner);

//        P11UpdateIngredientsByName(scanner);

    }

    private void P01SelectShampoosBySize(Scanner scanner) {
        String inputSize = scanner.nextLine();
        Size size = Size.valueOf(inputSize);

        this.shampooService.selectBySize(size)
                .forEach(shampoo -> System.out.printf("%s %s %.2f%n",
                        shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));
    }

    private void P02SelectShampoosBySizeOrLabel(Scanner scanner) {
        String inputSize = scanner.nextLine();
        long labelId = Long.parseLong(scanner.nextLine());
        Size size = Size.valueOf(inputSize);

        this.shampooService.selectBySizeOrLabel(size, labelId)
                .forEach(shampoo -> System.out.printf("%s %s %.2f%n",
                        shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));

    }

    private void P03SelectShampoosByPrice(Scanner scanner) {
        int inputPrice = Integer.parseInt(scanner.nextLine());

        this.shampooService.selectWithPriceHigherThan(BigDecimal.valueOf(inputPrice))
                .forEach(shampoo -> System.out.printf("%s %s %.2f%n",
                        shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));
    }

    private void P04SelectIngredientsByName(Scanner scanner) {
        String startLetter = scanner.nextLine();

        this.ingredientsService.selectStartsWith(startLetter)
                .forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    private void P05SelectIngredientsByNames(Scanner scanner) {

        List<String> ingredients = new ArrayList<>();

        String row;

        while ((row = scanner.nextLine()) != null && !row.isBlank()) {
            ingredients.add(row);
        }

        this.ingredientsService.selectWithGivenList(ingredients)
                .forEach(ingredient -> System.out.println(ingredient.getName()));

    }

    private void P06CountShampoosByPrice(Scanner scanner) {
        double inputPrice = Double.parseDouble(scanner.nextLine());

        int count = this.shampooService.countShampooWithLowerPrice(BigDecimal.valueOf(inputPrice));

        System.out.println(count);
    }

    private void P07SelectShampoosByIngredients(Scanner scanner) {
        Set<String> ingredients = new HashSet<>();

        String row;

        while ((row = scanner.nextLine()) != null && !row.isBlank()) {
            ingredients.add(row);
        }

        this.shampooService.selectByIngredients(ingredients)
                .forEach(shampoo -> System.out.println(shampoo.getBrand()));
    }

    private void P08SelectShampoosByIngredientsCount(Scanner scanner) {
        int inputNumber = Integer.parseInt(scanner.nextLine());

        this.shampooService.selectWithLessIngredients(inputNumber)
                .forEach(shampoo -> System.out.println(shampoo.getBrand()));
    }

    private void P09DeleteIngredientsByName(Scanner scanner) {
        String inputName = scanner.nextLine();
        this.ingredientsService.deleteByName(inputName);
    }

    protected void P10UpdateIngredientsByPercent(Scanner scanner) {

        double percent = Double.parseDouble(scanner.nextLine()) / 100;


        this.ingredientsService.updateAllIngredientsPriceByPercent(percent);
    }

    private void P11UpdateIngredientsByName(Scanner scanner) {
        Set<String> ingredients = new HashSet<>();

        String row;

        while ((row = scanner.nextLine()) != null && !row.isBlank()) {
            ingredients.add(row);
        }

        this.ingredientsService.updateAllPriceByNames(ingredients);
    }
}
