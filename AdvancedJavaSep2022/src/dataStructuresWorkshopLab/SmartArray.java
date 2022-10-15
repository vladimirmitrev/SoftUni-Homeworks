package dataStructuresWorkshopLab;

import java.util.function.Consumer;

public class SmartArray {
    private Integer[] data;
    private int size;

    public SmartArray() {
        this.data = new Integer[4];
        this.size = 0;

    }
    public void add(int element) {
        if(this.size == this.data.length) {
            this.data = grow();
        }
        this.data[size] = element;
        this.size++;
    }

    public int get(int index) {
        validateIndex(index);
        return this.data[index];
    }

    public int size() {
        return this.size;
    }
    public int remove(int index) {
        validateIndex(index);
        this.size--;
        int element = this.data[index];

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
            if(this.data[i] == element) {
                return true;
            }
        }
        return false;
    }
    public void addOnIndex(int index, int element) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        int lastElement = this.data[lastIndex];

        if (lastIndex - index >= 0)  {
            System.arraycopy(this.data, index, this.data, index + 1, lastIndex - index);
        }
        this.data[index] = element;

        add(lastElement);
        if(this.data.length / 2 >= this.size && this.data.length > 4) {
            this.data = shrink();
        }
    }

    public void forEach(Consumer<Integer> consumer)  {
        for (int i = 0; i < this.size; i++) {
            Integer el = this.data[i];
            consumer.accept(el);
        }
    }

    private void validateIndex(int size) {
        if(size < 0 || size >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index" + size);
        }
    }

    private Integer[] grow() {
        Integer[] newData = new Integer[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private Integer[] shrink() {
        Integer[] newData = new Integer[this.data.length / 2];

        System.arraycopy(this.data, 0, newData, 0, this.size);

        return newData;
    }
}
