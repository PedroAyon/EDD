package unidad3;

import unidad3.stack.Stack;

import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

public class BalancedBrackets {

    static String[] input = new String[]{
            "[()]{}{[()()]()}",
            "({{}}][])",
            "({[({[]})]})",
            "[[[[]]"
    };

    static Map<Character, Character> pairs = Map.ofEntries(
            entry('(', ')'),
            entry('[', ']'),
            entry('{', '}')
    );

    static Stack<Character> stack = new Stack<>(100);

    public static void main(String[] args) {
        Arrays.stream(input).forEach(s -> {
            System.out.println(validate(s) ? "Balanced" : "Not balanced");
        });
    }

    public static boolean validate(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (isOpenBrace(c)) stack.push(c);
            else {
                char top = stack.pop();
                if (!closes(top, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isOpenBrace(Character c) {
        return pairs.containsKey(c);
    }

    public static boolean closes(Character c1, Character c2) {
        return pairs.get(c1) == c2;
    }
}
