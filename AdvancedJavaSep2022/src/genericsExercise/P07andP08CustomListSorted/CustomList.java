package genericsExercise.P07andP08CustomListSorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }
    public void add(T element) {
        values.add(element);
    }
    public T remove(int index) {
        return values.remove(index);
    }
    public boolean contains(T element) {
        return values.contains(element);
    }
    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }
    public long countGreater(T element) {
        return values.stream().filter(item -> item.compareTo(element) > 0).count();
    }
    public T max() {
        return values.stream().max(Comparator.naturalOrder()).get();
    }
    public T min() {
        return values.stream().min(Comparator.naturalOrder()).get();
    }
    public int size(){
        return values.size();
    }
    public T getIndex(int index){
        return values.get(index);
    }

//    public void print() {
//        for (T value : values) {
//            System.out.println(value);
//        }
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s%n", value.toString()));
        }
        return sb.toString().trim();
    }
}
