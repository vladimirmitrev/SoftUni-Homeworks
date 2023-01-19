package genericsLab.StackGeneric;


import java.util.function.Consumer;

public class MyStackGeneric<E> {
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

    public void forEach(Consumer<E> consumer) {
        Node<E> current = this.top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }
    private void ensureNotEmpty() {
        if(this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
