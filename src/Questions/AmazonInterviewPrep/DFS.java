package Questions.AmazonInterviewPrep;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            this.V = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFS(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> itr = adj[v].listIterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n])
                    DFS(n, visited);
            }
        }
        void DFSUtil(int v)
        {
            boolean visited[] = new boolean[V];

            DFS(v, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFSUtil(2);
    }
}
