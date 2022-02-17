package kvo.graph;

public class Main {
    public static void main(String[] args) {

        System.out.println("Обход в глубину циклом while :");
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        for (int i = 0; i < 6; i++) {
            System.out.printf("Достижимо городов для %s города - %s%n", i, graph.deepCrawl(i) - 1 + " "); // пройдемся по всем вершинам
        }

        System.out.println("\nрешение через рекурсию :");
        GraphRecurs graphRecurs = new GraphRecurs(6);

        graphRecurs.addEdge(0, 1);
        graphRecurs.addEdge(1, 2);
        graphRecurs.addEdge(3, 4);
        for (int i = 0; i < 6; i++) {
            System.out.printf("Достижимо городов для %s города - %s%n", i, graphRecurs.Dfs(i) - 1 + " "); // пройдемся по всем вершинам
        }
    }
}
