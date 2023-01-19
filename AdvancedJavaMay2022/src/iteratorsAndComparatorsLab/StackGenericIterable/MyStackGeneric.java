package iteratorsAndComparatorsLab.StackGenericIterable;


import java.util.Iterator;
import java.util.function.Consumer;

public class MyStackGeneric<E> implements Iterable<E> {


    private static class Node<T> {

        private T element;
        private Node<T> prev;
        public Node(T element, Node prev) {
            this.element = element;
            this.prev = prev;
        }

    }
    private Node<E> top;

    private int size;
    public MyStackGeneric() {

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = top;


            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.prev;
                return element;
            }
        };
    }
    public void push(E element) {
        Node<E> newNode = new Node<E>(element, this.top);
        this.top = newNode;
        this.size++;
    }

    public E pop(){
        ensureNotEmpty();
        E element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    public E peek() {
        ensureNotEmpty();
        return this.top.element;
    }

//    public void forEach(Consumer<E> consumer) {
//        Node<E> current = this.top;
//
//        while (current != null) {
//            consumer.accept(current.element);
//            current = current.prev;
//        }
//    }
    private void ensureNotEmpty() {
        if(this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
