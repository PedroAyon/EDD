package unidad4.binary_tree;

public class Main {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(93);
        node.left = new Node<>(10);
        node.left.left = new Node<>(8);
        node.left.right = new Node<>(75);
        node.right = new Node<>(154);
        node.right.left = new Node<>(150);
        node.right.left.right = new Node<>(153);

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(node);
        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
    }
}
