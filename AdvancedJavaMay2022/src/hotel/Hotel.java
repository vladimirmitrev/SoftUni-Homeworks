package hotel;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public int getCount() {
        return this.roster.size();
    }
    public void add(Person person) {
        if (getCapacity() > getCount()) {
            roster.add(person);
        }
    }
    public boolean remove(String name) {
        return this.roster.removeIf(person -> person.getName().equals(name));
    }
    public Person getPerson(String name, String hometown) {
        return this.roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", name));
        this.roster.forEach(person -> sb.append(person).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
