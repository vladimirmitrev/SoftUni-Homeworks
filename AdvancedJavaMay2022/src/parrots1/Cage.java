package parrots1;

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
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public int count() {
        return this.data.size();
    }
    public void add(Parrot parrot) {
        if(getCapacity() > count()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(element -> element.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot par : this.data) {
            if(par.getName().equals(name)) {
                par.setAvailable(false);
                toReturn = par;
            }
        }
        return toReturn;

    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();
        this.data.forEach(par -> {
            if(par.getSpecies().equals(species)) {
                par.setAvailable(false);
                toReturn.add(par);
            }
        });
        return toReturn;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        this.data.stream().filter(parrot -> parrot.isAvailable())
                .forEach(element -> sb.append(element).append(System.lineSeparator()));
      return sb.toString().trim();
    }
}



