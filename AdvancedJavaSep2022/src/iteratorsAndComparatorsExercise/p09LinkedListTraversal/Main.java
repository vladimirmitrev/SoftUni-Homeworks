package iteratorsAndComparatorsExercise.p09LinkedListTraversal;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        LinkedList list = new LinkedList();
        while (n-->0){
            String []input = scanner.nextLine().split("\\s+");
            if ("Add".equals(input[0])) {
                list.add(Integer.parseInt(input[1]));
            } else {
                list.remove(Integer.parseInt(input[1]));
            }
        }
        System.out.println(list.getSize());
        list.forEach(e-> System.out.print(e+" "));
    }
}
