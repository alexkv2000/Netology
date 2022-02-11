package kvo.graph;

public class Graph {
    private int maxN = 6;
    private int[][] arrayGraph; // матрица графа (ребра)
    private Vertex[] vertexList; //список вершин label + посещение
    private int curN;
    private MyStack stack = new MyStack(maxN);

    public Graph(int maxN) {
        this.maxN = maxN;
        this.arrayGraph = new int[maxN][maxN];
        this.vertexList = new Vertex[maxN];
        this.curN = 0;
    }

    public void addVertex(int name) {
        vertexList[curN++] = new Vertex(name);
    }

    public void addEdge(int start, int end) {
        arrayGraph[start][end] = 1;
        arrayGraph[end][start] = 1;
    }

    public int check(int v) {
        for (int i = 0; i < curN; i++) {
            if (arrayGraph[v][i] == 1 && vertexList[i].isVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public int deepCrawl(int index) { //обход в глубину с указаной вершины
        int[] count = new int[this.maxN];
        count[index]++;
//        System.out.print(vertexList[index].V + " ");
        vertexList[index].isVisited = true; // отмечаем что мы уже здесь были
        stack.push(index); // пушим в стек для обхода

        while (!stack.isEmpty()) {
            int neighbour = check(stack.peek()); // берем соседа

            if (neighbour == -1) {
                neighbour = stack.pop(); // сосей нет -> убираем из стека поиска вершину
            } else {
                count[index]++;
//                System.out.print(vertexList[neighbour].V + " ");
                vertexList[neighbour].isVisited = true;
                stack.push(neighbour);
            }
        }

        for (int i = 0; i < curN; i++) { // сбросим флаги для цикла обхода
            vertexList[i].isVisited = false;
        }
        return count[index];
    }
}