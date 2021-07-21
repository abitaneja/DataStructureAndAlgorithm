package com.graph;

import java.util.List;

public abstract class Graph {
    private final int numVertices;
    private final boolean isDirected;

    public Graph(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
    }

    public Graph(int numVertices) {
        this(numVertices, false);
    }

    public abstract void addEdge(int v1, int v2, int weight);

    public abstract void addEdge(int v1, int v2);

    public abstract List<Integer> getAdjacentVertices(int v);

    public abstract long getInDegree(int v);

    public abstract long getOutDegree(int v);

    public abstract int getEdgeWeight(int v1, int v2);

    public abstract void display();

    public int getNumVertices() {
        return numVertices;
    }

    public boolean isDirected() {
        return isDirected;
    }
}
