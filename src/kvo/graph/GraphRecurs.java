package kvo.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphRecurs {
    private int maxN;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    GraphRecurs(int maxN) {
        this.maxN = maxN;
        adjLists = new LinkedList[maxN];
        visited = new boolean[maxN];

        for (int i = 0; i < maxN; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }

    int Dfs(int vertex) {
        int size = 1;
        visited[vertex] = true;
//        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = (int) ite.next();
            if (!visited[adj])
                size += Dfs(adj);

        }
        for (int i = 0; i < maxN; i++) {
            visited[vertex] = false;
        }
        return size;
    }
}
