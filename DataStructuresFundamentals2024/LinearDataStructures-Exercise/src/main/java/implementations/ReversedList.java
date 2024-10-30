package implementations;

import java.util.Iterator;

public class ReversedList<E> implements interfaces.ReversedList<E> {
    private final int INITIAL_CAPACITY = 2;

    private int size;
    private int head;
    private int tail;
    private Object[] elements;

    public ReversedList() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        this.head = this.tail = middle;
    }
    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2;

        Object[] newElements = new Object[newCapacity];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);

        return newElements;
    }
//        int middle = newCapacity / 2;
//
//        int begin = middle - this.size / 2;
//
//        int index = this.head;
//
//        for (int i = begin; index <= this.tail; i++) {
//            newElements[i] = this.elements[index++];
//        }
//
//        this.head = begin;
//        this.tail = this.head + this.size - 1;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public E get(int index) {
        int realIndex = this.tail - index;
        this.ensureIndex(realIndex);

        return this.getAtCasted(realIndex);
    }

    @Override
    public E removeAt(int index) {
        int begin = tail - index;
        E element = getAtCasted(begin);
        this.ensureIndex(begin);

        for (int i = begin; i < tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.tail] = null;
        this.tail--;
        this.size--;

        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = tail;
            @Override
            public boolean hasNext() {
                return index >= head;
            }

            @Override
            public E next() {
                return getAtCasted(index--);
            }
        };
    }

    @SuppressWarnings("unchecked")
    private E getAtCasted(int index) {
        return (E) this.elements[index];
    }

    private void ensureIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail) {
            throw new IndexOutOfBoundsException("Index out of bound for index: " + (realIndex - this.head));
        }
    }
}
