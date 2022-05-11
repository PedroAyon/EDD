package unidad3.linked_list.doubly_linked_list;

public class DoublyLinkedList<E> {
    private Node<E> head;

    public void linkLast(E data) {
        final Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<E> node = head;
        while (node.next != null)
            node = node.next;
        node.next = newNode;
        newNode.prev = node;
    }

    public void linkFirst(E data) {
        final Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public boolean linkBefore(E key, E data) {
        if (head == null) return false;
        if (head.data == key) {
            linkFirst(data);
            return true;
        }
        final Node<E> newNode = new Node<>(data);
        Node<E> node = head.next;
        while (node != null) {
            if (node.data == key) {
                final Node<E> prev = node.prev;
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = node;
                node.prev = newNode;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean linkAfter(E key, E data) {
        if (head == null) return false;
        final Node<E> newNode = new Node<>(data);
        Node<E> node = head;
        while (node != null) {
            if (node.data == key) {
                final Node<E> next = node.next;
                node.next = newNode;
                newNode.prev = node;
                newNode.next = next;
                if (next != null)
                    next.prev = newNode;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void unlinkFirst() {
        if (head == null) return;
        Node<E> next = head.next;
        if (next != null) {
            next.prev = null;
            head.next = null;
            head.data = null;
        }
        head = next;
    }

    public void unlinkLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node<E> node = head.next;
        while (node.next != null)
            node = node.next;
        node.prev.next = null;
        node.data = null;
        node.prev = null;
    }

    public void unlink(E key) {
        if (head == null) return;
        Node<E> node = head;
        while (node != null) {
            if (node.data == key) {
                final Node<E> next = node.next;
                final Node<E> prev = node.prev;
                if (prev == null)
                    head = next;
                else {
                    prev.next = next;
                    node.prev = null;
                }
                if (next != null)
                    next.prev = prev;
                node.data = null;
                return;
            }
            node = node.next;
        }
    }

    public boolean search(E key) {
        if (head == null) return false;
        Node<E> node = head;
        while (node.data != key) {
            if (node.next == null) return false;
            node = node.next;
        }
        return true;
    }

    @Override
    public String toString() {
        if (head == null) return "Empty list";
        StringBuilder out = new StringBuilder(String.valueOf(head.data));
        Node<E> node = head.next;
        while (node != null) {
            out.append(" -> ").append(node.data);
            node = node.next;
        }
        return out.toString();
    }

    public String toReversedString() {
        if (head == null) return "Empty list";
        StringBuilder out = new StringBuilder();
        Node<E> node = head;
        while (node.next != null)
            node = node.next;
        while (node != head) {
            out.append(node.data).append(" -> ");
            node = node.prev;
        }
        out.append(head.data);
        return out.toString();
    }
}
