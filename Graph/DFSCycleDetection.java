package Graph;

import java.util.*;

class DFSCycleDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        List<List<Integer>> adjlst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String adj = sc.nextLine().trim();
            List<Integer> lst = new ArrayList<>();
            if (!adj.equals("")) {
                String adjarr[] = adj.split(" ");
                for (String s : adjarr) {
                    lst.add(Integer.parseInt(s));
                }
            }
            adjlst.add(lst); // Always add even if empty
        }

        boolean[] visited = new boolean[n];
        boolean[] inpath = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycle(adjlst, inpath, visited, n, i)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static boolean hasCycle(List<List<Integer>> adjlst, boolean[] inpath, boolean[] visited, int n, int index) {
        visited[index] = true;
        inpath[index] = true;

        for (int j : adjlst.get(index)) {
            if (!visited[j]) {
                if (hasCycle(adjlst, inpath, visited, n, j)) {
                    return true;
                }
            } else if (inpath[j]) {
                return true;
            }
        }

        inpath[index] = false;
        return false;
    }
}
