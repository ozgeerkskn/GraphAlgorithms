package algorithm_hw2;

import java.util.*;

public class FloydWarshall {
    private Graph graph;

    public FloydWarshall(Graph graph) {
        this.graph = graph;
    }

    public void run() {
        int V = graph.getVertexCount();
        int[][] dist = new int[V][V];
        int INF = Integer.MAX_VALUE / 2; // Infinity representation

        // Start: Distance to self 0, others INF
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Start from the edges of graph
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.getAdjList().get(u)) {
                dist[u][edge.target] = edge.weight;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) { // Overflow prevention
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Output
   
        System.out.println("Shortest paths between all pairs:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] >= INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
