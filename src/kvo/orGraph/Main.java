package kvo.orGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.add_edge(0, 1);
        graph.add_edge(0, 3);
        graph.add_edge(1, 2);
        graph.add_edge(1, 3);
//        graph.add_edge(2, 6);
//        graph.add_edge(4, 5);
//        graph.add_edge(3, 4);
        virusize_meme(graph, 0);
    }

    static void virusize_meme(Graph graph, int start_user) {
        boolean[] visited = new boolean[graph.size()];   // [V раз нет]; - получал ли пользователь уже этот мем
        Queue<Integer> sent = new LinkedList<>(); // будем складывать пользователей
        sent.add(start_user);       // добавить start_user в sent ==[0]
        /*** будем поочерёдно доставать пользователей и для каждого добавлять в неё тех,
         * кому он отправит мем,
         * но за исключением тех людей, которые уже его видели.
         * Тот пользователь, которого мы достанем из очереди последним
         * (когда он не сможет никому отправить из тех кто ещё не видел мем), и будет искомым ответом:
         ***/
        int lastViewFinish = 0;
        while (!sent.isEmpty()) {
            int lastViewer = sent.poll();
            int index = 0;

            if (!visited[lastViewer]) {
                visited[lastViewer] = true;
                lastViewFinish = lastViewer;
//                System.out.printf("Пользователь %s увидел мем%n", lastViewer);
                for (int vertex : graph.nexts(lastViewer)) {
                    if (vertex == 1) {
                        sent.add(index);
                    }
                    index++;
                }
            }
        }
        System.out.printf("%s%nПользователь %s увидел мем последним%n", "-".repeat(35), lastViewFinish);
    }
}
