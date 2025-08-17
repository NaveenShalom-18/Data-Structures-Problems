package Graph;

import java.util.*;

public class MinWeightCycleFW {
    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            Arrays.fill(dist[i], INF);

        // Initialize distances with given edge weights
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = w; // directed graph
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Find minimum weight cycle
        int minCycle = INF;
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (u != v && dist[v][u] < INF && dist[u][v] < INF) {
                    minCycle = Math.min(minCycle, dist[u][v] + dist[v][u]);
                }
            }
        }

        if (minCycle == INF)
            System.out.println("No cycle found");
        else
            System.out.println("Minimum weight cycle: " + minCycle);
    }
}
