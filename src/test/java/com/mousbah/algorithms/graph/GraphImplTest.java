package com.mousbah.algorithms.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphImplTest {

    @Test
    public void testBreadthFirstSearch() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        a.addEdge(c, 1);
        a.addEdge(b, 1);
        b.addEdge(c, 1);
        c.addEdge(d, 1);
        Graph graph = new GraphImpl();
        graph.addVertex(a);

        List<Vertex> vertexList = new ArrayList<>();
        graph.breadthFirstSearch(vertexList::add);
        assertEquals("Breadth First Search did not return a correct result!", vertexList, Arrays.asList(a, c, b, d));

    }

    @Test
    public void testFindShortestPath() {
        Graph graph = new GraphImpl();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        a.addEdge(b, 1);
        a.addEdge(f, 10);
        b.addEdge(c, 1);
        b.addEdge(e, 2);
        c.addEdge(d, 2);
        d.addEdge(e, 1);
        e.addEdge(f, 1);
        graph.addVertex(a);

        List<Vertex> shortestPath = graph.findShortestPath(a, f);
        assertEquals("Shortest path is not correct", shortestPath, Arrays.asList(a, b, e, f));
    }

    @Test
    public void testHasCycles() {
        Graph graph = new GraphImpl();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        a.addEdge(b, 1);
        b.addEdge(c, 1);
        c.addEdge(d, 1);
        d.addEdge(e, 1);
        e.addEdge(f, 1);
        f.addEdge(c, 1);
        graph.addVertex(a);

        assertTrue("Cycle detection algorithm failed!", graph.hasCycles());
    }

    @Test
    public void testTopologicalSort() {
        Graph graph = new GraphImpl();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        f.addEdge(d, 1);
        f.addEdge(e, 1);
        d.addEdge(b, 1);
        e.addEdge(b, 1);
        e.addEdge(c, 1);
        b.addEdge(a, 1);
        c.addEdge(a, 1);
        graph.addVertices(a, b, c, d, e, f);
        List<Vertex> topologicalSort = graph.topologicalSort();
        assertEquals("Topological sort did not work!", Arrays.asList(f,e,d,c,b,a), topologicalSort);
    }
}