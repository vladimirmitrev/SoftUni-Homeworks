package interfacesAndAbstractionExercise.militaryEliteVM;

public class PrivateImpl extends SoldierImpl implements Private {

    protected double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }


    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.getSalary());
    }
}
