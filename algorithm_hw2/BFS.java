package algorithm_hw2;

import java.util.*;

public class BFS {
    private Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public void run(int start) {
        boolean[] visited = new boolean[graph.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS starting from vertex " + start + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : graph.getAdjList().get(current)) {
                int neighbor = edge.target;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}
