package Graph;

import java.util.*;

class ShortestPathUnitWeighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices and edges
        int V = sc.nextInt();
        int E = sc.nextInt();

        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // since the graph is undirected
        }

        // Source node input
        int src = sc.nextInt();

        // Compute shortest paths
        int[] dist = shortestPath(V, adj, src);

        // Output distances
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + " : " + dist[i]);
        }
    }

    // BFS-based shortest path
    public static int[] shortestPath(int V, List<List<Integer>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1); // -1 indicates unreachable
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }
}
