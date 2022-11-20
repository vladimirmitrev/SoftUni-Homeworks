package DesignPatternsExercise.strategyExample;

import java.util.Comparator;

public class firstNameSorter implements Comparator<Person> {
    @Override
    public int compare(Person left, Person right) {

        return left.getFirstName().compareTo(right.getFirstName());
    }
}
