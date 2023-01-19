package cafe1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if(this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String employee) {
        return this.employees.removeIf(element -> element.getName().equals(employee));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }
    public Employee getEmployee(String name) {
        return this.employees.stream().filter(element -> element.getName().equals(name)).findFirst().get();
    }

    public int getCount() {
        return this.employees.size();
    }

    public String getName() {
        return name;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s:%n", getName()));
        this.employees.forEach(element -> sb.append(element).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
