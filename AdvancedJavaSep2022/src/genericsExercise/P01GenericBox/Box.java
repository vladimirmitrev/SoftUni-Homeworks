package genericsExercise.P01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
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
