package com.mousbah.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    private String name;
    private List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Vertex targetVertex, double weight) {
        Edge edge = new Edge(weight, this, targetVertex);
        edges.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
