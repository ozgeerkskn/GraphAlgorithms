package algorithm_hw2;

import java.util.*;

public class Kruskal {
    private List<Edge> edges;
    private int V;

    public Kruskal(List<Edge> edges, int V) {
        this.edges = edges;
        this.V = V;
    }

    public void runMST() {
    	// Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.target;

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU != rootV) {
                mst.add(edge);
                totalWeight += edge.weight;
                union(parent, rootU, rootV);
            }
        }

        // Output
        System.out.println("Kruskal MST result:");
        for (Edge e : mst) {
            System.out.println(e.source + " - " + e.target + " (weight: " + e.weight + ")");
        }
        System.out.println("Total MST weight: " + totalWeight);
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootY] = rootX;
    }
}
