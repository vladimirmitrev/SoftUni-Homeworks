package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Animal animal) {
        if(capacity > data.size()) {
            this.data.add(animal);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(animal -> animal.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }
    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparingInt(Animal::getAge)).get();
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:%n"));

        this.data.stream().forEach(animal -> sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker())));

        return sb.toString().trim();
    }
}
