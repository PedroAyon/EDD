package unidad4.binary_tree;

public class Node<T extends Comparable<T>> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean equals(T value) {
        return this.value.compareTo(value) == 0;
    }

    public boolean lessThan(T value) {
        return this.value.compareTo(value) < 0;
    }

    public boolean greaterThan(T value) {
        return this.value.compareTo(value) > 0;
    }
}
