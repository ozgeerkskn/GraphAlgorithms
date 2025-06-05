package algorithm_hw2;

import java.util.*;

public class DFS {
    private Graph graph;
    private boolean[] visited;
    private boolean[] recStack;
    private int[] parent;
    private List<Integer> cyclePath;

    public DFS(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVertexCount()];
        recStack = new boolean[graph.getVertexCount()];
        parent = new int[graph.getVertexCount()];
        Arrays.fill(parent, -1);
        cyclePath = new ArrayList<>();
    }

    public boolean hasCycle() {
        for (int node = 0; node < graph.getVertexCount(); node++) {
            if (!visited[node]) {
                if (detectCycle(node)) {
                    printCycle();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCycle(int u) {
        visited[u] = true;
        recStack[u] = true;

        for (Edge edge : graph.getAdjList().get(u)) {
            int v = edge.target;
            if (!visited[v]) {
                parent[v] = u;
                if (detectCycle(v)) return true;
            } else if (recStack[v]) {
                // cycle found
                buildCycle(u, v);
                return true;
            }
        }

        recStack[u] = false;
        return false;
    }

    private void buildCycle(int start, int end) {
        cyclePath.clear();
        cyclePath.add(end);
        int curr = start;
        while (curr != end && curr != -1) {
            cyclePath.add(curr);
            curr = parent[curr];
        }
        cyclePath.add(end); 
        Collections.reverse(cyclePath);
    }

    private void printCycle() {
        System.out.print("Cycle detected: ");
        for (int v : cyclePath) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
