package unidad3;

import java.util.Stack;

/**
 * @author Pedro Ayon
 */
public class InfixToPostfix {
    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') stack.pop();
                    else return "Invalid expression";
                }
                else return "Invalid expression";
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) result.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(infixToPostfix("a*b/(a+c)"));
        System.out.println(infixToPostfix("4*(5+6-(8/2^3)-7)-1"));
    }
}
