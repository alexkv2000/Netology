package kvo.graph;

public class Graph<Integer> {
    private int maxN = 6;
    private final int[][] arrayGraph; // матрица графа (ребра)
    private final Vertex<Integer>[] vertexList; //список вершин label + посещение
    private MyStack<Integer> stack = new MyStack(maxN);

    public Graph(int maxN) {
        this.maxN = maxN;
        this.vertexList = new Vertex[maxN];
        this.arrayGraph = new int[maxN][maxN];
        for (int i = 0; i < maxN; i++) {
            vertexList[i] = new Vertex(i);
        }
    }

    public void addEdge(int start, int end) {
        arrayGraph[start][end] = 1;
        arrayGraph[end][start] = 1;
    }

    public int check(int v) {
        for (int i = 0; i < maxN; i++) {
            if (arrayGraph[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    public int deepCrawl(int index) { //обход в глубину с указаной вершины
        int[] count = new int[this.maxN]; // массив достижимости городов (количество)
        count[index]++;
        vertexList[index].isVisited = true; // отмечаем что мы уже здесь были
        stack.push(index); // пушим в стек для обхода
        while (!stack.isEmpty()) {
            int neighbour = check(stack.peek()); // берем соседа
            if (neighbour == -1) {
                neighbour = stack.pop(); // соседей нет -> убираем из стека поиска вершину
            } else {
                count[index]++;
                vertexList[neighbour].isVisited = true;
                stack.push(neighbour);
            }
        }
        for (int i = 0; i < maxN; i++) { // сбросим флаги для цикла обхода
            vertexList[i].isVisited = false;
        }
        return count[index];
    }
}
