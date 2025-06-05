package algorithm_hw2;

public class Edge {
    public int source; 
    public int target;
    public int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

   
    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}
