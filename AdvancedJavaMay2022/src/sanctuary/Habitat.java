package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if(capacity > this.data.size()) {
            data.add(elephant);
        }
    }
    public boolean remove(String name) {
        return this.data.removeIf(elephant -> elephant.getName().equals(name));
    }
    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }
    public Elephant getOldestElephant() {
        return Collections.max(data, Comparator.comparingInt(Elephant::getAge));
    }
    public int getAllElephants(){
        return this.data.size();
    }
    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        sb.append(System.lineSeparator());
        this.data.forEach(elephant ->
                sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom())));
       return sb.toString().trim();
    }

}
