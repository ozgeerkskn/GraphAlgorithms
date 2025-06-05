package algorithm_hw2;

import java.util.*;

public class Graph {
    private int V; // Vertex number
    private List<List<Edge>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Adding directed edges (graph directed)
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
    }

    // Access methods for nodes and edges
    public int getVertexCount() {
        return V;
    }

    public List<List<Edge>> getAdjList() {
        return adjList;
    }

    // Print graph structure to console
    public void printGraph() {
    	 System.out.print("Graph Structure");
    	 System.out.println();
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("-> " + edge.target + "(" + edge.weight + ") ");
            }
            System.out.println();
            
        }
       
        System.out.println();
    }
}
