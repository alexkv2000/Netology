package kvo.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        for (int i = 0; i < 6; i++) {
            System.out.print(graph.deepCrawl(i) - 1 + " "); // пройдемся по всем вершинам
        }
    }
}
