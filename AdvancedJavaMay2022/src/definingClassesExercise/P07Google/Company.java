package definingClassesExercise.P07Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    public String format() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}
