package bakery;

import java.util.ArrayList;
import java.util.Collections;
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
    public void add(Employee employee) {
        if(capacity > employees.size()) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return this.employees.removeIf(emp -> emp.getName().equals(name));
    }
    public Employee getOldestEmployee() {
        return Collections.max(employees, Comparator.comparingInt(Employee::getAge));
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:%n", this.name));
        this.employees.stream().forEach(employee -> sb.append(employee).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
