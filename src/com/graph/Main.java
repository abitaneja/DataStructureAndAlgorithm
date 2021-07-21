package com.graph;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
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

        IntStream.range(0, 4).forEach(i -> {
            System.out.println("OutDegree: " + i + " " + g.getOutDegree(i));
        });

        for (int i = 0; i < g.getNumVertices(); i++) {
            List<Integer> adjacentVertices = g.getAdjacentVertices(i);
            for (int j = 0; j < adjacentVertices.size(); j++) {
                System.out.printf("Edge weight: i=%d j=%d weight=%d", i, j, g.getEdgeWeight(i, j));
                System.out.println();
            }
        }
    }
}
