package implementations;

import interfaces.Solvable;

import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        Stack<Character> stack = new Stack<>();

        for (char symbol : parentheses.toCharArray()) {
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isMatchingPair(open, symbol)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatchingPair(char open, char close) {
        return  (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');

    }
}
