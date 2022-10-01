package definingClassesExercise.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int numOfBadge;
    private List<Pokemon> pokemon;

    public Trainer() {
        this.numOfBadge = 0;
        this.pokemon = new ArrayList<>();
    }
    

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public void setNumOfBadge() {
        this.numOfBadge++;
    }

    public List<Pokemon> getPokemon() {
        return new ArrayList<>(this.pokemon);
    }
    public int pokeCollectionSize() {
        return this.pokemon.size();
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon1 ->
            new Pokemon(pokemon1.getName(), pokemon1.getElement(), pokemon1.getHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemon = this.pokemon.stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public int getNumOfBadge() {
        return numOfBadge;
    }
}





