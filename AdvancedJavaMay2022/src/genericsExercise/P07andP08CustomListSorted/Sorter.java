package genericsExercise.P07andP08CustomListSorted;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T current = list.getIndex(i);
            for (int j = i + 1; j < list.size(); j++) {
                if(current.compareTo(list.getIndex(j)) > 0) {
                    list.swap(i ,j);
                }
            }
        }
    }
}
