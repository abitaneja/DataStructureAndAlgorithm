package com.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdjacencyMatrixGraph extends Graph {
    private final int[][] matrix;

    public AdjacencyMatrixGraph(int numVertices, boolean isDirected) {
        super(numVertices, isDirected);
        matrix = new int[numVertices][numVertices];
    }

    public AdjacencyMatrixGraph(int numVertices) {
        this(numVertices, false);
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if (v1 >= super.getNumVertices() || v2 >= super.getNumVertices() || v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Vertices " + v1 + " and " + v2 + " are out of bounds");
        }
        if (weight < 1) {
            throw new IllegalArgumentException("An edge cannot have weight <1");
        }
        matrix[v1][v2] = weight;
        if (!isDirected()) {
            matrix[v2][v1] = weight;
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 1);
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= getNumVertices() || v < 0) {
            throw new IllegalArgumentException("cannot access vertex " + v);
        }
        List<Integer> adjacentVertices = new ArrayList<>();
        IntStream.range(0, getNumVertices()).forEach(i -> {
            if (matrix[v][i] > 0) {
                adjacentVertices.add(i);
            }
        });
        return adjacentVertices;
    }

    @Override
    public long getInDegree(int v) {
        if (v >= getNumVertices() || v < 0) {
            throw new IllegalArgumentException("cannot access vertex " + v);
        }
        return IntStream.range(0, getNumVertices()).filter(i -> matrix[i][v] > 0).count();

    }

    @Override
    public long getOutDegree(int v) {
        return getAdjacentVertices(v).size();
    }

    @Override
    public int getEdgeWeight(int v1, int v2) {
        return matrix[v1][v2];
    }

    @Override
    public void display() {
        for (int i = 0; i < getNumVertices(); i++) {
            List<Integer> adjacentVerticesList = getAdjacentVertices(i);
            for (int v = 0; v < adjacentVerticesList.size(); v++) {
                int adj = adjacentVerticesList.get(v);
                System.out.println(i + " -->" + adj);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new AdjacencyMatrixGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);

        IntStream.range(0, 4).forEach(i -> {
            System.out.println("Adjacent to: " + i + " " + g.getAdjacentVertices(i));
        });

        IntStream.range(0, 4).forEach(i -> {
            System.out.println("InDegree: " + i + " " + g.getInDegree(i));
        });

    /*    IntStream.range(0, 4).forEach(i -> {
            System.out.println("OutDegree: " + i + " " + g.getOutDegree(i));
        });*/

        for (int i = 0; i < g.getNumVertices(); i++) {
            List<Integer> adjacentVertices = g.getAdjacentVertices(i);
            for (int j = 0; j < adjacentVertices.size(); j++) {
                int adj = adjacentVertices.get(j);
                System.out.printf("Edge weight: %d  %d : Weight %d", i, adj, g.getEdgeWeight(i, adj));
                System.out.println();
            }
        }
        g.display();
    }
}
