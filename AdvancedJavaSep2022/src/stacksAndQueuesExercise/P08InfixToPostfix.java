package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String current : input) {
            if (!"-+/*()".contains(current)) {
                outputQueue.offer(current);
            } else if (current.equals("(")) {
                operatorsStack.push(current);
            } else if (current.equals(")")&&(!operatorsStack.isEmpty() && !operatorsStack.peek().equals("("))) {
                outputQueue.offer(operatorsStack.pop());
                operatorsStack.pop();
            } else {
                if ("-+".contains(current)) {
                    while (!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                } else {
                    while (!operatorsStack.isEmpty() && !"+-(".contains(operatorsStack.peek())) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                }
                operatorsStack.push(current);
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));
    }
}
