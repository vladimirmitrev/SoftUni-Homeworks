package DesignPatternsExercise.singleton.zooExample;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Owner owner = new Owner();

        owner.buyAnimals("Zebra", 5);
        employee.feedAnimals();
    }
}
