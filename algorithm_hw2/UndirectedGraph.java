package algorithm_hw2;

import java.util.*;

public class UndirectedGraph {
    private List<Edge> edges;
    private int V;

    public UndirectedGraph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
        edges.add(new Edge(dest, src, weight)); 
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getVertexCount() {
        return V;
    }
}
