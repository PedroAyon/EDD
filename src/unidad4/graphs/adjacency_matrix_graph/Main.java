package unidad4.graphs.adjacency_matrix_graph;

public class Main {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>(5, false);
        graph.insertVertex('a');
        graph.insertVertex('b');
        graph.insertVertex('c');
        graph.insertVertex('d');
        graph.insertEdge(1, 2);
        graph.insertEdge(3, 4);
        graph.insertEdge(2, 3);
        graph.print();
        System.out.println();

        graph.insertVertex('e');
        graph.insertEdge(5, 4);
        graph.insertEdge(3, 5);
        graph.print();
        System.out.println();

        graph.deleteVertex(2);
        graph.print();
        System.out.println();

        graph.insertVertex('f');
        graph.print();
    }
}
