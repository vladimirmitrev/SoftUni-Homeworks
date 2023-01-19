package iteratorsAndComparatorsExercise.P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

     class Frog implements Iterator<Integer> {
            private int index = 0;
            boolean finishedRound = false;
            @Override
            public boolean hasNext () {
            return index < numbers.size();
        }
            @Override
            public Integer next () {
                int currentIndex = index;
                index += 2;
                if(index >= numbers.size() && !finishedRound) {
                    index = 1;
                    finishedRound = true;
                }
            return numbers.get(currentIndex);
        }
        };
    }

