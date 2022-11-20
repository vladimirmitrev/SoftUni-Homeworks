package DesignPatternsExercise.prototypeExercise;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord komi = new EmployeeRecord(
                1, "Komi", "Junior", 10000.0,"Sofia");

        Prototype komi2 = komi.getClone();

        komi.showRecord();

    }
}
