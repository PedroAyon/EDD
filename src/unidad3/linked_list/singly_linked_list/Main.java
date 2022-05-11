package unidad3.linked_list.singly_linked_list;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int opt;
        System.out.println("""
                    0 - Exit
                    1 - Link Last
                    2 - Link First
                    3 - Link Before
                    4 - Link After
                    5 - Unlink First
                    6 - Unlink Last
                    7 - Unlink Element
                    8 - Search
                    9 - Print List""");
        do {
            opt = Integer.parseInt(input("Option"));
            switch (opt) {
                case 1 -> linkedList.linkLast(
                        Integer.valueOf(input("Element"))
                );
                case 2 -> linkedList.linkFirst(
                        Integer.valueOf(input("Element"))
                );
                case 3 -> linkedList.linkBefore(
                        Integer.valueOf(input("Key")),
                        Integer.valueOf(input("Element"))
                );
                case 4 -> linkedList.linkAfter(
                        Integer.valueOf(input("Key")),
                        Integer.valueOf(input("Element"))
                );
                case 5 -> linkedList.unlinkFirst();
                case 6 -> linkedList.unlinkLast();
                case 7 -> linkedList.unlink(
                        Integer.valueOf(input("Element"))
                );
                case 8 -> System.out.println(
                        linkedList.search(
                                Integer.valueOf(input("Element"))
                        ) ? "Found!" : "Not found"
                );
                case 9 -> System.out.println(linkedList);
            }
        } while (opt != 0);
    }

    private static String input(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
