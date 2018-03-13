package Graph;

/**
 * Created by choijaeyong on 2016. 3. 22..
 */
public class Graph_ex {
    public static void main(String[] args) {
        Graph g1 = new Graph();

        g1.addVertex('a');
        g1.addVertex('b');
        g1.addVertex('c');
        g1.addVertex('d');
        g1.addVertex('e');
        g1.addVertex('f');
        g1.addVertex('g');
        g1.addVertex('h');

        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,7);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(4,5);
        g1.addEdge(4,6);
        g1.addEdge(4,7);

        System.out.println("--- DFS 출력 ---");
        g1.dfs();

        System.out.println("--- BFS 출력 ---");
        g1.bfs();


    }
}
