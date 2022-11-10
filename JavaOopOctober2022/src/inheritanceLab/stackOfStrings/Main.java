package inheritanceLab.stackOfStrings;

public class Main {
    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push("Komi");
        System.out.println(myStack.pop());

        StackOfStrings stackOfStrings = new StackOfStrings();

        stackOfStrings.push("Orion");
        stackOfStrings.push("Alien");
        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.peek());

    }
}
