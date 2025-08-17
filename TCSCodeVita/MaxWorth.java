package TCSCodeVita;

import java.io.*;
import java.util.*;

public class MaxWorth {
    static int N, M, budget;
    static String[] words;
    static int[] cost, worth;
    static boolean[][] conflict;
    static Map<String, Integer> indexMap = new HashMap<>();
    static int[][] memo;

    // Helper to safely read non-empty line
    static String readNonEmptyLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) return line;
        }
        return null;
    }

    static int dfs(int i, int remainingBudget, List<Integer> chosen) {
        if (i == N) return 0;
        if (memo[i][remainingBudget] != -1) return memo[i][remainingBudget];

        // Option 1: skip current string
        int best = dfs(i + 1, remainingBudget, chosen);

        // Option 2: take current string if budget allows & no conflict
        if (remainingBudget >= cost[i]) {
            boolean ok = true;
            for (int j : chosen) {
                if (conflict[i][j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                chosen.add(i);
                best = Math.max(best,
                        worth[i] + dfs(i + 1, remainingBudget - cost[i], chosen));
                chosen.remove(chosen.size() - 1);
            }
        }

        return memo[i][remainingBudget] = best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(readNonEmptyLine(br));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        words = readNonEmptyLine(br).split(" ");
        cost = new int[N];
        worth = new int[N];

        st = new StringTokenizer(readNonEmptyLine(br));
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            indexMap.put(words[i], i);

            // compute worth of each string
            int sum = 0;
            for (char c : words[i].toCharArray())
                sum += (c - 'a' + 1);
            worth[i] = sum;
        }

        conflict = new boolean[N][N];
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(readNonEmptyLine(br));
            int a = indexMap.get(st.nextToken());
            int b = indexMap.get(st.nextToken());
            conflict[a][b] = conflict[b][a] = true;
        }

        budget = Integer.parseInt(readNonEmptyLine(br));

        memo = new int[N][budget + 1];
        for (int[] row : memo) Arrays.fill(row, -1);

        System.out.println(dfs(0, budget, new ArrayList<>()));
    }
}
