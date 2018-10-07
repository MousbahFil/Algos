package com.mousbah.algorithms.graph;


import java.util.List;
import java.util.function.Function;

public interface Graph {

    void addVertices(List<Vertex> vertices);

    void addVertices(Vertex... vertices);

    void addVertex(Vertex vertex);

    List<Vertex> findShortestPath(Vertex sourceVertex,Vertex destinationVertex);

    <T> void breadthFirstSearch(Function<Vertex, T> function);

    boolean hasCycles();

    List<Vertex> topologicalSort();
}
