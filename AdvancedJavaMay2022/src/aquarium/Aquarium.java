package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }
    public void add(Fish fish) {
        if(getCapacity() > getFishInPool()) {
            if(!fish.getName().equals(name)) {
                this.fishInPool.add(fish);
            }
        }
    }
    public boolean remove(String name) {
        return this.fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(fish -> fish.getName().equals(name)).findFirst().orElse(null);
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));
        this.fishInPool.forEach(fish -> sb.append(fish).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
