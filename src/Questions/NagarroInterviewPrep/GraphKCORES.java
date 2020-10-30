package Questions.NagarroInterviewPrep;

import java.util.Arrays;
import java.util.Vector;

class GraphKCORES {
    int V;
    Vector<Integer>[] adj;

    @SuppressWarnings("unchecked")
    GraphKCORES(int V) {
        this.V = V;
        this.adj = new Vector[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Vector<>();
        }
    }

    void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    boolean DFSUtil(int v, boolean[] visited, int[] vDegree, int k) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (vDegree[v] < k)
                vDegree[i]--;

            if (!visited[i]) {
                if (DFSUtil(i, visited, vDegree, k))
                    vDegree[v]--;
            }
        }
        return (vDegree[v] < k);
    }

    void printKCores(int k) {
        boolean[] visited = new boolean[V];
        boolean[] processed = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(processed, false);

        int mindeg = Integer.MAX_VALUE;
        int startvertex = 0;

        int[] vDegree = new int[V];
        for (int i = 0; i < V; i++) {
            vDegree[i] = adj[i].size();
            if (vDegree[i] < mindeg) {
                mindeg = vDegree[i];
                startvertex = i;
            }
        }

        DFSUtil(startvertex, visited, vDegree, k);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFSUtil(i, visited, vDegree, k);
        }
        System.out.println("K-Cores : ");
        for (int v = 0; v < V; v++) {
            if (vDegree[v] >= k) {
                System.out.printf("\n[%d]", v);

                for (int i : adj[v]) {
                    if (vDegree[i] >= k)
                        System.out.printf(" -> %d", i);
                }
            }
        }
    }

    public static void main(String[] args)
    {

        // Create a graph given in the above diagram
        int k = 3;
        GraphKCORES g1 = new GraphKCORES(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.printKCores(k);

        System.out.println();

        GraphKCORES g2 = new GraphKCORES(13);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(2, 8);
        g2.addEdge(2, 9);
        g2.addEdge(3, 10);
        g2.addEdge(3, 11);
        g2.addEdge(3, 12);
        g2.printKCores(k);
    }
}
