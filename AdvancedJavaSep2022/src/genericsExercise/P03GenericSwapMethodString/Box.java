package genericsExercise.P03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {

//        T temp = values.get(firstIndex);
//        values.set(firstIndex, values.get(secondIndex));
//        values.set(secondIndex, temp);

        Collections.swap(values, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T value : values) {
            stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return stringBuilder.toString();
    }
}