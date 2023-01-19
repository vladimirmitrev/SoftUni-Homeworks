package iteratorsAndComparatorsExercise.P02Collection;

import java.util.Iterator;
import java.util.List;

public class Collection implements Iterable<String>{
    private List<String> elements;
    private int currentIndex;

    public Collection(String... elements) {
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

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;
            @Override
            public boolean hasNext() {
                return  index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index);
                index++;
                return element;
            }
        };
    }
}
