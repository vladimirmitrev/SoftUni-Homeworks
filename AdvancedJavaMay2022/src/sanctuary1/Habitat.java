package sanctuary1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Elephant elephant) {
        if(getCapacity() > data.size()) {
            this.data.add(elephant);
        }
    }


    public boolean remove(String name) {
        return this.data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(place -> place.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream()
                .max(Comparator.comparing(Elephant::getAge))
                .get();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        this.data.forEach(elephant -> sb.append(String.format("%s came from: %s"
                        , elephant.getName(), elephant.getRetiredFrom()))
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }

//    public String getReport(){
//        StringBuilder sB = new StringBuilder();
//        sB.append("Saved elephants in the park:").append(System.lineSeparator());
//        for (Elephant elephant : this.data) {
//            sB.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()))
//                    .append(System.lineSeparator());
//        }
//        return sB.toString().trim();
//    }


}
