package unidad3.stack;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * @author Pedro Ayon
 */
public class Stack<E> {
    private ArrayList<E> array;
    private int top = -1;
    private final int size;

    Stack(int size) {
        this.size = size;
        this.array = new ArrayList<>(size);
    }

    void push(E element) {
        if (top + 1 == size) {
            System.out.println("Stack overflow.");
            return;
        }
        top++;
        if (array.size() > top) array.set(top, element);
        else array.add(element);
    }

    E lastElement() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return array.get(top);
    }

    int top() {
        if (isEmpty()) System.out.println("Empty stack");
        return top;
    }

    void pop() {
        if (isEmpty()) System.out.println("Empty stack");
        else top--;
    }

    void clear() {
        while (!isEmpty()) this.pop();
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    int size() {
        return array.size();
    }

    boolean search(E target) {
        return IntStream.rangeClosed(0, top).anyMatch(i -> array.get(i) == target);
    }

    void invert() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return;
        }
        ArrayList<E> aux = new ArrayList<>(size);
        for (int i = top; i >= 0; i--) {
            aux.add(array.get(i));
        }
        array = aux;
    }

    void printElements() {
        if (isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }
        for (int i = 0; i < top; i++) {
            System.out.print(array.get(i) + " -> ");
        }
        System.out.println(array.get(top));
    }

}
