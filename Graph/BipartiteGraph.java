package Graph;

import java.util.*;

class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfsCheck(int[][] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0; // Start coloring with 0

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    // Assign opposite color to neighbor
                    color[neighbor] = 1 - color[node];
                    q.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // Conflict found
                    return false;
                }
            }
        }
        return true;
    }
}
