package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if(this.capacity > count()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(name1 -> name1.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }
//    public Present getPresent(String name){
//        return this.data.stream().filter(element->element.getName().equals(name)).findFirst().orElse(null);
//    }

    public Present getPresent(String name) {
        for (Present names : data) {
            if(name.equals(names.getName())) {
                return names;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(getColor()).append(String.format(" bag contains:%n"));
        this.data.forEach(element -> sb.append(element).append(System.lineSeparator()));
        return sb.toString();
    }
    // Black bag contains:
// Present Doll (0.40) for a girl
// Present Train (2.00) for a boy

}
