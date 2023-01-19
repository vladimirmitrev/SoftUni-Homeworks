package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void addEgg(Egg egg) {
        if (getCapacity() > getCount()) {
            this.data.add(egg);
        }
    }
    public boolean removeEgg(String color) {
        return this.data.removeIf(egg -> egg.getColor().equals(color));
    }
    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparingInt(Egg::getStrength)).orElse(null);
    }
    public Egg getEgg(String color) {
        return this.data.stream().filter(egg -> egg.getColor().equals(color)).findFirst().orElse(null);
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:%n", material));
        this.data.forEach(egg -> sb.append(egg).append(System.lineSeparator()));

        return sb.toString().trim();
    }

}
