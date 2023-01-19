package parrots1;

public class Parrot {
    private String name;
    private String species;
    private boolean available;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean bool) {
        this.available = bool;
    }


    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", this.species, this.name);
    }
}
