package iteratorsAndComparatorsExercise.P01ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size() - 1;
    }
    public boolean move(){
        if(hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }
    public void print() {
        if(this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation");
        }
        System.out.println(this.elements.get(currentIndex));
    }
}
