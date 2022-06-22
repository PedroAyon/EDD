package unidad4.graphs.adjacency_matrix_graph;

import java.util.ArrayList;

public class Graph<T> {
    private int numberOfVertices;
    private final int maxNumberOfVertices;
    private final boolean[][] matrix;
    private ArrayList<T> tags;
    private final boolean isDirected;

    public Graph(Integer maxNumberOfVertices, Boolean isDirected) {
        this.isDirected = isDirected;
        this.maxNumberOfVertices = maxNumberOfVertices;
        matrix = new boolean[this.maxNumberOfVertices + 1][this.maxNumberOfVertices + 1];
        tags = new ArrayList<>();
        tags.add(null);
    }

    public void insertEdge(int v1, int v2) {
        if (v1 > numberOfVertices || v2 > numberOfVertices) {
            System.out.println("Invalid operation.");
            return;
        }
        matrix[v1][v2] = true;
        if (!isDirected)
            matrix[v2][v1] = true;
    }

    public void insertVertex(T tag) {
        if (numberOfVertices >= maxNumberOfVertices) {
            System.out.println("Graph is full.");
            return;
        }
        tags.add(tag);
        numberOfVertices++;
    }

    public void deleteVertex(T tag) {
        int index = tags.indexOf(tag);
        if (index == -1) {
            System.out.println("Vertex " + tag + " does not exists.");
            return;
        }
        deleteVertex(index);
    }

    public void deleteVertex(int v) {
        if (v > numberOfVertices) {
            System.out.println("Vertex " + v + " does not exists.");
            return;
        }
        for (int i = v; i < numberOfVertices; i++)
            for (int j = 1; j <= numberOfVertices; j++)
                matrix[i][j] = matrix[i + 1][j];

        for (int i = v; i < numberOfVertices; i++)
            for (int j = 1; j <= numberOfVertices; j++)
                matrix[j][i] = matrix[j][i + 1];

        for (int i = 0; i <= numberOfVertices; i++) {
            matrix[i][numberOfVertices] = false;
            matrix[numberOfVertices][i] = false;
        }
        tags.remove(v);
        numberOfVertices--;
    }

    public boolean isEmpty() {
        return numberOfVertices == 0;
    }

    public boolean adjacency(int v1, int v2) {
        return matrix[v1][v2] || matrix[v2][v1];
    }

    public void print() {
        for (int i = 1; i <= numberOfVertices; i++) {
            System.out.print(tags.get(i) + " ");
            for (int j = 1; j <= numberOfVertices; j++)
                System.out.print((matrix[i][j] ? '1' : '0') + " ");
            System.out.println();
        }
    }
}
