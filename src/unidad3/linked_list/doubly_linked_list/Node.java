package unidad3.linked_list.doubly_linked_list;

public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data) {
        this.data = data;
    }
}
