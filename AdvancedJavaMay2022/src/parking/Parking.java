package parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if(this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
       return this.data.stream()
               .max(Comparator.comparingInt(Car::getYear))
               .orElse(null);
        //return Collections.max(data, Comparator.comparingInt(Car::getYear)); няма null
    }
    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer)
                        && car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n", this.type));
        this.data.forEach(car -> sb.append(car).append(System.lineSeparator()));
        return sb.toString().trim();
    }

}
