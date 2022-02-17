package kvo.orGraph;

public class Graph {
    final int Vertex;
    int next = 0;
    int[][] vertices_info; //- изначально массив из V пустых множеств / списков

    public Graph(int vertex) {
        Vertex = vertex;
        vertices_info = new int[Vertex][Vertex];
    }

    void add_edge(int x, int y) {
        vertices_info[x][y] = 1;
        vertices_info[y][x] = 1;
    }

    int[] nexts(int index) {  // вывод следующей схемы взаимедействия вершины
        return vertices_info[index];
    }

    int size() {
        return Vertex;
    }
}
