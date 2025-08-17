package BackTracking;
import java.util.*;
class EscapeMaze {
    public static final int max_visits = 20000;
    public static final int bounds = 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for(int b[] : blocked) {
            blockedSet.add(b[0]+","+b[1]);
        }
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    public static boolean bfs(int start[], int target[], Set<String> blockedSet) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        visited.add(start[0]+","+start[1]);
        queue.add(start);

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty() && visited.size() < max_visits) {
            int curr[] = queue.poll();
            if(curr[0] == target[0] && curr[1] == target[1]) return true;
            for(int dir[] : dirs) {
                int nx = dir[0] + curr[0];
                int ny = dir[1] + curr[1];
                String path = nx+","+ny;
                if(nx >= 0 && ny >= 0 && nx < bounds && ny < bounds && !blockedSet.contains(path) && !visited.contains(path)) {
                    visited.add(path);
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return visited.size() >= max_visits;
    }

}