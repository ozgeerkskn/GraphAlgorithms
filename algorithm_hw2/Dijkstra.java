package algorithm_hw2;

import java.util.*;

public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public void run(int start) {
        // Negative weight control
        for (List<Edge> edges : graph.getAdjList()) {
           for (Edge edge : edges) {
                if (edge.weight < 0) {
                    System.out.println("ERROR: Dijkstra cannot contain negative weighted edges.");
                    return;
                }
            }
  }

        int V = graph.getVertexCount();
        int[] dist = new int[V];
        int[] previous = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (current.distance > dist[u]) continue;

            for (Edge edge : graph.getAdjList().get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Output
      
        System.out.println("Dijkstra (source: " + start + ") shortest paths:");
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
