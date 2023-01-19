package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Car car) {
        if(getCapacity() > getCount()) {
         data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(element -> element.getManufacturer().equals(manufacturer)
                && element.getModel().equals(model));
    }
    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }
    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(element ->
                element.getManufacturer().equals(manufacturer)
                        && element.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" The cars are in a car dealership %s:%n", this.name));
        this.data.forEach(element -> sb.append(element).append(System.lineSeparator()));
        return sb.toString().trim();
    }

}
