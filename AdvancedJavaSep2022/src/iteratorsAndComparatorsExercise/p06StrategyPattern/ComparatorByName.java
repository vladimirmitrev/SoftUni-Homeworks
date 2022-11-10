package iteratorsAndComparatorsExercise.p06StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {


    @Override
    public int compare(Person first, Person second) {

        if(first.getName().length() == second.getName().length()) {
            char firstPerson = first.getName().toLowerCase().charAt(0);
            char secondPerson = second.getName().toLowerCase().charAt(0);
            return Character.compare(firstPerson, secondPerson);
        }
        return Integer.compare(first.getName().length(), second.getName().length());
    }
}
