package encapsulationLab.increaseSalary;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        double bonusReduced = age < 30 ? bonus / 100 / 2 : bonus / 100;

        double factor = 1.00 + bonusReduced;

        salary = factor * salary;
    }



    @Override
    public String toString() {
        return String.format("%s %s gets %.3f leva", firstName, lastName, salary);
    }
}
