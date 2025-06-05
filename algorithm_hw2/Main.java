package algorithm_hw2;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(9);

        
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 2);
        g.addEdge(3, 4, 2);
        //g.addEdge(3, 4, -1);
        g.addEdge(2, 3, 6);
        //g.addEdge(2, 3, -2);
        g.addEdge(2, 6, 3);
        g.addEdge(1, 6, 2);
        g.addEdge(6, 4, 4);
        //g.addEdge(6, 4, -3);
        g.addEdge(4, 5, 1);
        g.addEdge(5, 1, 3); 
        g.addEdge(4, 7, 7);
        g.addEdge(1, 8, 8); 
        //g.addEdge(1, 8, -5);
        g.addEdge(7, 8, 6);
       
        
        // Print graph
        g.printGraph();

        BFS bfs = new BFS(g);
        System.out.println("\n--- BFS ---");
        for (int i = 0; i < g.getVertexCount(); i++) {
            bfs.run(i);
        }
        
        System.out.println();

        // Cycle control
        System.out.println("\n--- DFS ---");
        DFS dfs = new DFS(g);
        if (dfs.hasCycle()) {
            System.out.println("Graph contains cycle.");
        } else {
            System.out.println("Graph does not contain cycle.");
        }
          
        System.out.println("\n--- Dijkstra ---");
        Dijkstra dijkstra = new Dijkstra(g);
        dijkstra.run(0); // Shortest paths starting from 0
        
        System.out.println("\n--- BellmanFord ---");
        BellmanFord bf = new BellmanFord(g);
        bf.run(0);
        
        System.out.println("\n--- Floyd-Warshall ---");
        FloydWarshall fw = new FloydWarshall(g);
        fw.run();
        
        System.out.println("\n--- Kruskal MST (Undirected Graph) ---");
        UndirectedGraph ug = new UndirectedGraph(9);

        // Undirected edges
        ug.addEdge(0, 1, 5);
        ug.addEdge(0, 2, 2);
        ug.addEdge(1, 8, 8);
        ug.addEdge(2, 3, 6);
        ug.addEdge(2, 6, 3);
        ug.addEdge(3, 4, 2);
        ug.addEdge(4, 7, 7);
        ug.addEdge(4, 5, 1);
        ug.addEdge(5, 1, 3);
        ug.addEdge(1, 6, 2);
        ug.addEdge(6, 4, 4);
        ug.addEdge(7, 8, 6);

        Kruskal kruskal = new Kruskal(ug.getEdges(), ug.getVertexCount());
        kruskal.runMST();


    }
}
