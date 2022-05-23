package unidad4.binary_tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(93);
        tree.insert(10);
        tree.insert(8);
        tree.insert(75);
        tree.insert(154);
        tree.insert(150);
        tree.insert(153);

        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
        System.out.println();

        if (tree.find(154))
            System.out.println("154 found!");

        tree.delete(154);
        tree.traverseInOrder();
        System.out.println();

        if (tree.find(154))
            System.out.println("154 found!");
        else
            System.out.println("154 not found");
    }
}
