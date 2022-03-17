package unidad3.stack;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Pedro Ayon
 */
public class Main {

    static Stack<Integer> stack;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opt;
        System.out.print("Stack size: ");
        int stackSize = scanner.nextInt();
        stack = new Stack<>(stackSize);
        do {
            System.out.print("""
                    Select an option:
                    1  - push
                    2  - last element
                    3  - top
                    4  - pop
                    5  - clear stack
                    6  - is empty
                    7  - is full
                    8  - size
                    9  - search
                    10 - invert
                    11 - print elements
                    0  - exit
                    """);
            opt = scanner.nextInt();
            stackOpt(opt);
        } while (opt != 0);
    }

    public static void stackOpt(int opt) {
        switch (opt) {
            case 1 -> {
                System.out.print("Element: ");
                stack.push(scanner.nextInt());
            }
            case 2 -> System.out.println(stack.lastElement());
            case 3 -> System.out.println(stack.top());
            case 4 -> stack.pop();
            case 5 -> stack.clear();
            case 6 -> System.out.println(stack.isEmpty());
            case 7 -> System.out.println(stack.isFull());
            case 8 -> System.out.println(stack.size());
            case 9 -> {
                System.out.print("Target: ");
                if (stack.search(scanner.nextInt())) System.out.println("Found!");
                else System.out.println("Not found.");
            }
            case 10 -> stack.invert();
            case 11 -> stack.printElements();
        }
        System.out.println();
    }
}
