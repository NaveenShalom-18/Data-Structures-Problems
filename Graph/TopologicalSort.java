package Graph;

import java.util.*;

class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices and edges
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v); // Directed edge u -> v
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, stack, adj);
        }

        System.out.println("Topological Sort:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor])
                dfs(neighbor, visited, stack, adj);
        }
        stack.push(node);  // Push after all neighbors are visited
    }
}
