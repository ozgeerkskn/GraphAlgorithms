package algorithm_hw2;

import java.util.*;

public class BellmanFord {

    private Graph graph;

    public BellmanFord(Graph graph) {
        this.graph = graph;
    }

    public void run(int start) {
        int V = graph.getVertexCount();
        int[] dist = new int[V];
        int[] previous = new int[V]; 

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        dist[start] = 0;

        // Relax the edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : graph.getAdjList().get(u)) {
                    int v = edge.target;
                    int weight = edge.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        previous[v] = u;
                    }
                }
            }
        }

        // Negative cycle check
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.getAdjList().get(u)) {
                int v = edge.target;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycles.");
                    return;
                }
            }
        }

        // Output
        System.out.println("Bellman-Ford (source: " + start + ") shortest path:");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " - Distance: Unreachable | Path: -");
            } else {
                System.out.print("Vertex " + i + " - Distance: " + dist[i] + " | Path: ");
                printPath(previous, i);
                System.out.println();
            }
        }
    }

    private void printPath(int[] previous, int current) {
        List<Integer> path = new ArrayList<>();
        while (current != -1) {
            path.add(current);
            current = previous[current];
        }
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" → ");
            }
        }
    }
}
