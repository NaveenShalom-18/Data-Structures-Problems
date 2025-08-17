package Graph;

import java.util.*;

public class DFSCycleDetectionUndirected {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // number of vertices
        int E = sc.nextInt(); // number of edges

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        boolean hasCycle = isCycle(V, adj);
        System.out.println("Cycle exists: " + hasCycle);
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) {
                return true; // Found a back edge => cycle
            }
        }

        return false;
    }
}
