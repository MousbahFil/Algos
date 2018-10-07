package com.mousbah.algorithms.graph;

import java.util.*;
import java.util.function.Function;

public class GraphImpl implements Graph {

    private List<Vertex> vertices;

    public GraphImpl() {
        this.vertices = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    @Override
    public void addVertices(List<Vertex> vertices) {
        this.vertices.addAll(vertices);
    }

    @Override
    public void addVertices(Vertex... vertices) {
        this.vertices.addAll(Arrays.asList(vertices));
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);

    }

    @Override
    public List<Vertex> findShortestPath(Vertex sourceVertex, Vertex destinationVertex) {
        VertexInfo sourceVertexInfo = new VertexInfo(sourceVertex);
        sourceVertexInfo.setDistance(0);
        Map<Vertex, VertexInfo> map = new LinkedHashMap<>();
        breadthFirstSearch(v -> {
            map.put(v, new VertexInfo(v));
            return null;
        });
        map.put(sourceVertex, sourceVertexInfo);

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>();
        map.values().forEach(queue::add);

        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            Vertex vertex = vertexInfo.getVertex();

            for (Edge edge : vertex.getEdges()) {
                Vertex targetVertex = edge.getTargetVertex();
                VertexInfo targetVertexInfo = map.get(targetVertex);
                if (targetVertexInfo.getDistance() > vertexInfo.getDistance() + edge.getWeight()) {
                    queue.remove(targetVertexInfo);
                    targetVertexInfo.setDistance(vertexInfo.getDistance() + edge.getWeight());
                    targetVertexInfo.setPredecessor(vertexInfo);
                    map.put(targetVertex, targetVertexInfo);
                    queue.add(targetVertexInfo);
                }
            }
        }

        List<Vertex> result = new ArrayList<>();
        VertexInfo v = map.get(destinationVertex);

        while (v != null) {
            result.add(v.getVertex());
            v = v.getPredecessor();
        }
        Collections.reverse(result);
        return result;
    }

    @Override
    public <T> void breadthFirstSearch(Function<Vertex, T> function) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visitedVertices = new HashSet<>();
        for (Vertex v : vertices) {//Adding root Vertices
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            if (!visitedVertices.contains(vertex)) {
                visitedVertices.add(vertex);
                function.apply(vertex);
                for (Edge edge : vertex.getEdges()) {
                    queue.add(edge.getTargetVertex());
                }
            }
        }
    }

    @Override
    public boolean hasCycles() {
        Set<Vertex> visitedVertices = new HashSet<>();
        Set<Vertex> verticesBeingVisited = new HashSet<>();

        for (Vertex v : vertices) {
            if (visitedVertices.contains(v)) {
                continue;
            } else if (hasCycles(v, visitedVertices, verticesBeingVisited)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vertex> topologicalSort() {
        if (hasCycles()) {
            throw new IllegalStateException("The Graph has a cycle, therefore the topological sort algorithm does not support it");
        }
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> set = new HashSet<>();

        for (Vertex v : vertices) {
            if (set.contains(v)) {
                continue;
            }
            topologicalSort(v, stack, set);
        }
        List<Vertex> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topologicalSort(Vertex v, Stack<Vertex> stack, Set<Vertex> visitedVertices) {
        if (visitedVertices.contains(v)) {
            return;
        }
        visitedVertices.add(v);
        for (Edge e : v.getEdges()) {
            Vertex targetVertex = e.getTargetVertex();
            topologicalSort(targetVertex, stack, visitedVertices);
        }
        stack.push(v);
    }

    private boolean hasCycles(Vertex v, Set<Vertex> visitedVertices, Set<Vertex> verticesBeingVisited) {
        verticesBeingVisited.add(v);
        for (Edge e : v.getEdges()) {
            Vertex targetVertex = e.getTargetVertex();
            if (visitedVertices.contains(targetVertex)) {
                continue;
            } else if (verticesBeingVisited.contains(targetVertex)) {
                return true;
            }
            if (hasCycles(targetVertex, visitedVertices, verticesBeingVisited)) {
                return true;
            } else {
                verticesBeingVisited.remove(targetVertex);
            }
        }
        verticesBeingVisited.remove(v);
        visitedVertices.add(v);
        return false;
    }


    private class VertexInfo implements Comparable<VertexInfo> {
        private Vertex vertex;
        private double distance;
        private VertexInfo predecessor;

        public VertexInfo(Vertex vertex) {
            this.vertex = vertex;
            this.distance = Double.MAX_VALUE;
        }


        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Vertex vertex) {
            this.vertex = vertex;
        }

        public VertexInfo getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(VertexInfo predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public int compareTo(VertexInfo o) {
            return Double.compare(this.distance, o.distance);
        }
    }
}
