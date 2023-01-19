package iteratorsAndComparatorsLab.SmartArrayGenericIterable;

import java.util.Iterator;
import java.util.function.Consumer;

public class SmartArray<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public SmartArray() {
        this.data = new Object[4];
        this.size = 0;

    }
//    private class SmartArrayIterator implements Iterator<E> {
//        private int i = 0;
//
//        @Override
//        public boolean hasNext() {
//            return i < size;
//        }
//        @Override
//        public E next() {
//            E element = (E)data[i];
//            i++;
//            return element;
//           // return get(i);
//        }
//    }

    @Override
    public Iterator<E> iterator() {
//        return new SmartArrayIterator();
        return new Iterator<E>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                E element = (E)data[i];
                i++;
                return element;
              //  return get(i);
            }
        };
    }
    public void add(E element) {
        if(this.size == this.data.length) {
            this.data = grow();
        }
        this.data[size] = element;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validateIndex(index);
        return (E)this.data[index];
    }
    public int size() {
        return this.size;
    }

    public E remove(int index) {
        validateIndex(index);
        this.size--;
        E element = get(index);

        if (this.size - index >= 0) {
            System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        }

        this.data[this.size] = null;

        if(this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }

        return element;
    }
    public boolean contains(int element) {
        for (int i = 0; i < this.size ; i++) {
            if(this.data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void addOnIndex(int index, E element) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        E lastElement = get(lastIndex);

        if (lastIndex - index >= 0)  {
            System.arraycopy(this.data, index, this.data, index + 1, lastIndex - index);
        }
        this.data[index] = element;

        add(lastElement);
        if(this.data.length / 2 >= this.size && this.data.length > 4) {
            this.data = shrink();
        }
    }
//    public void forEach(Consumer<E> consumer)  {
//        for (int i = 0; i < this.size; i++) {
//            E el = get(i);
//            consumer.accept(el);
//        }

//    }

    private void validateIndex(int size) {
        if(size < 0 || size >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index" + size);
        }
    }

    private Object[] grow() {
        Object[] newData = new Object[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private Object[] shrink() {
        Object[] newData = new Object[this.data.length / 2];

        System.arraycopy(this.data, 0, newData, 0, this.size);

        return newData;
    }
}
