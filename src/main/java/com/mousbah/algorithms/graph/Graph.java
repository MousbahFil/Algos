package com.mousbah.algorithms.graph;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

public interface Graph {

    void addVertices(List<Vertex> vertices);


    List<Vertex> findShortestPath(Vertex sourceVertex,Vertex destinationVertex);

    <T> void breadthFirstSearch(Function<Vertex, T> function);
}
