package groomingSalon1;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if(capacity > data.size()) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(element -> element.getName().equals(name));
    }
    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(element -> element.getName().equals(name) && element.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sB = new StringBuilder();
        sB.append(" The grooming salon has the following clients:").append(System.lineSeparator());
        this.data.forEach(pet -> sB.append(String.format("%s %s%n", pet.getName(), pet.getOwner())));
        //this.data.stream().forEach(element -> sB.append(element.getName()).append(" ").append(element.getOwner()).append(System.lineSeparator()));
        return sB.toString().trim();
    }
}
