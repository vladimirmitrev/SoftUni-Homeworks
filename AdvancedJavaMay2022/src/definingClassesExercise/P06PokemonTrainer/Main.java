package definingClassesExercise.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        Pokemon pokemon = null;
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.putIfAbsent(trainerName, new Trainer());
            trainerMap.get(trainerName).addPokemon(pokemon);


            input = scanner.nextLine();
        }
        String command = scanner.nextLine();


        while (!command.equals("End")) {

            for (Map.Entry<String, Trainer> kvp : trainerMap.entrySet()) {
                if(kvp.getValue().pokeCollectionSize() > 0) {
                    boolean havePokemon = false;
                    for(Pokemon pokemon1 : kvp.getValue().getPokemon()) {
                        if(pokemon1.getElement().equals(command)) {
                            havePokemon = true;
                            kvp.getValue().setNumOfBadge();
                            break;
                        }
                    }
                    if(!havePokemon) {
                        kvp.getValue().missingPokemonPenalty();
                    }
                }
            }
            command = scanner.nextLine();
        }
        trainerMap.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumOfBadge(), b1.getValue().getNumOfBadge()))
                .forEach(trainer -> {
                    System.out.println(String.format("%s %s %s",
                            trainer.getKey() ,
                            trainer.getValue().getNumOfBadge(),
                            trainer.getValue().pokeCollectionSize()));
                });
    }

}
