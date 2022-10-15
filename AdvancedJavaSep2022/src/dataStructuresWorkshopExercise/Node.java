package dataStructuresWorkshopExercise;

public class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
