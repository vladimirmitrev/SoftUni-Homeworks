package genericsLab.StackGeneric;

public class Main {
    public static void main(String[] args) {

        MyStackGeneric stack = new MyStackGeneric<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.pop();

        stack.forEach(System.out::println);



    }
}
