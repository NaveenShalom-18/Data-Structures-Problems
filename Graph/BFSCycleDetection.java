package Graph;

import java.util.*;

class BFSCycleDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.hasNextLine() ? sc.nextLine().trim() : "";
            List<Integer> lst = new ArrayList<>();
            if (!line.equals("")) {
                String[] arr = line.split(" ");
                for (String s : arr) {
                    lst.add(Integer.parseInt(s));
                }
            }
            adj.add(lst);
        }

        System.out.println(hasCycleBFS(adj, n));
    }

    public static boolean hasCycleBFS(List<List<Integer>> adj, int n) {
        int[] indegree = new int[n];

        // Step 1: Compute indegree of each node
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Step 2: Add nodes with 0 indegree to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        // Step 3: Process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: If not all nodes were processed, a cycle exists
        return count != n;
    }
}
