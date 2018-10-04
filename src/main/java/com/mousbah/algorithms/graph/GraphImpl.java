package com.mousbah.algorithms.graph;

import java.util.*;
import java.util.function.Function;

public class GraphImpl implements Graph {

    private List<Vertex> vertices;

    public GraphImpl() {
        this.vertices = new ArrayList<>();
    }

    public static void main(String[] args) {
        Graph graph = new GraphImpl();

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        a.addEdge(b, 20);
        a.addEdge(c, 10);
        b.addEdge(c, 1);
        b.addEdge(d, 2);
        b.addEdge(e, 2);
        c.addEdge(e, 2);
        e.addEdge(f, 2);
        a.addEdge(e, 100);
        graph.addVertices(Arrays.asList(a));

        graph.breadthFirstSearch(v -> {
            System.out.println(String.format("Visiting vertex '%s'", v.getName()));
            return null;
        });

        System.out.println(graph.findShortestPath(a, e));
    }

    @Override
    public void addVertices(List<Vertex> vertices) {
        this.vertices = vertices;
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
        for (Vertex v : vertices) {
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
