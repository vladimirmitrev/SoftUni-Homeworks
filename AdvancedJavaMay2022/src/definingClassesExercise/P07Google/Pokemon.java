package definingClassesExercise.P07Google;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
    public String format(){
        return String.format("%s %s",pokemonName,pokemonType);
    }

}
