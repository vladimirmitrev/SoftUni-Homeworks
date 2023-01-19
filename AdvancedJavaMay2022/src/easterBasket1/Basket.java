package easterBasket1;

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

    public String getMaterial() {
        return material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addEgg(Egg egg) {
        if(capacity > this.data.size()) {
            this.data.add(egg);
        }
    }
    public boolean removeEgg(String color) {
        return this.data.removeIf(element -> element.getColor().equals(color));
    }


    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparingInt(Egg::getStrength))
                .orElse(null);
    }


    public Egg getEgg(String color) {
        return this.data.stream()
                .filter(element -> element.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(getMaterial()).append(" basket contains:").append(System.lineSeparator());
        this.data.forEach(element -> sb.append(element).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
