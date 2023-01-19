package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (getCapacity() > count()) {
            this.data.add(parrot);
        }
    }

    public int count() {
        return this.data.size();
    }
    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }
    public Parrot sellParrot(String name) {

       Parrot parrot = this.data.stream().filter(par -> par.getName().equals(name)).findFirst().get();
       parrot.setAvailable(false);
       return parrot;
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toSell = new ArrayList<>();
        this.data.forEach(par -> {
            if(par.getSpecies().equals(species)) {
                par.setAvailable(false);
                toSell.add(par);
            }
        });
        return toSell;
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", name));
        this.data.stream().filter(par -> par.isAvailable())
                .forEach(parrot -> sb.append(parrot).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
