package unidad4.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T value) {
        root = new Node<>(value);
    }

    public BinarySearchTree(Node<T> node)  {
        root = node;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null)
            return new Node<>(value);
        if (node.greaterThan(value))
            node.left = insert(node.left, value);
        else if (node.lessThan(value))
            node.right = insert(node.right, value);
        return node;
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null)
            return null;
        if (node.equals(value)) {
            if (node.isLeaf())
                return null;
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            T smallestValue = findSmallestValue(node.right);
            node.value = smallestValue;
            node.right = delete(node.right, smallestValue);
            return node;
        }
        if (node.greaterThan(value))
            node.left = delete(node.left, value);
        else
            node.right = delete(node.right, value);
        return node;
    }

    private T findSmallestValue(Node<T> node) {
        return node.left == null ? node.value : findSmallestValue(node.left);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node == null)
            return;
        traverseInOrder(node.left);
        System.out.print(node.value + " ");
        traverseInOrder(node.right);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node<T> node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node<T> node) {
        if (node == null)
            return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(node.value + " ");
    }

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(Node<T> node, T value) {
        if (node == null)
            return false;
        if (node.equals(value))
            return true;
        return node.greaterThan(value) ? find(node.left, value) : find(node.right, value);
    }

    public void traverseLevelOrder() {
        if (root == null)
            return;
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.remove();
            System.out.print(node.value + " ");
            if (node.left != null)
                nodes.add(node.left);
            if (node.right != null)
                nodes.add(node.right);
        }
    }
}
