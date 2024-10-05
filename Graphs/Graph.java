package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//Implementation of graphs using adjacency matrix

// public class Graph {
//     int[][] adjMatrix;

//     public Graph(int node) {
//         adjMatrix = new int[node][node];
//     }

//     void addEdge(int u, int v) {
//         this.adjMatrix[u][v] = 1;
//         this.adjMatrix[v][u] = 1;
//     }

//     public static void main(String[] args) {
//         Graph g = new Graph(4);
//         g.addEdge(1, 2);
//         g.addEdge(3, 0);
//         g.addEdge(2, 2);
//     }
// }

// Implementation of graph using adjacency list

public class Graph {

    LinkedList<Integer>[] adj;
    int vertices;

    public Graph(int node) {
        adj = new LinkedList[node];
        vertices = node;
        for (int i = 0; i < node; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u , v){
        this.adj[u].add(v) ;
        this.adj[v].add(u) ;
    }

    public void bfs(int s) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(2, 2);
    }
}
