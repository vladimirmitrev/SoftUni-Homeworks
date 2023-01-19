package bakery1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return employees.size();
    }

    public void add(Employee employee) {
        if (getCapacity() > getCount()) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return employees.removeIf(element -> element.getName().equals(name));
    }
    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }
    public Employee getEmployee(String name) {
        return this.employees.stream().filter(element -> element.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name ));
        this.employees.stream().forEach(employee -> sb.append(employee).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
