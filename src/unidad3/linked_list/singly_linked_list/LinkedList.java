package unidad3.linked_list.singly_linked_list;

public class LinkedList<E> {
    private Node<E> head;

    public void linkLast(E data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<E> last = head;
        while (last.next != null)
            last = last.next;
        last.next = new Node<>(data);
    }

    public void linkFirst(E data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<E> aux = head;
        head = new Node<>(data, aux);
    }

    public boolean linkBefore(E key, E data) {
        Node<E> node = head;
        if (head.data == key) {
            head = new Node<>(data, node);
            return true;
        }
        while (node.next != null) {
            if (node.next.data == key) {
                node.next = new Node<>(data, node.next);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean linkAfter(E key, E data) {
        Node<E> node = head;
        while (node != null) {
            if (node.data == key) {
                node.next = new Node<>(data, node.next);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public E unlinkFirst() {
        final E data = head.data;
        final Node<E> next = head.next;
        head.data = null;
        head.next = null;
        head = next;
        return data;
    }

    public E unlinkLast() {
        if (head.next == null) {
            final E data = head.data;
            head = null;
            return data;
        }
        Node<E> node = head.next;
        Node<E> prev = head;
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        E data = node.data;
        node.data = null;
        return data;
    }

    public void unlink(E key) {
        if (head.data == key) {
            Node<E> next = head.next;
            head.data = null;
            head.next = null;
            head = next;
            return;
        }
        Node<E> node = head.next;
        Node<E> prev = head;
        while (node != null) {
            if (node.data == key) {
                prev.next = node.next;
                node.data = null;
                node.next = null;
                return;
            }
            prev = node;
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

    public LinkedList<E> cloneList() {
        LinkedList<E> clone = new LinkedList<>();
        Node<E> node = head;
        while (node != null) {
            clone.linkLast(node.data);
            node = node.next;
        }
        return clone;
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
}
