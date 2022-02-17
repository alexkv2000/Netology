package kvo.graph;

public class Vertex<Integer> {
    private int V;
    boolean isVisited;

    public Vertex(int V) {
        this.V = V;
        this.isVisited = false;
    }
}
