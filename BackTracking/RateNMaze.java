package BackTracking;

import java.util.*;

public class RateNMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        List<String> lst = new ArrayList<>();
        lst = solveNMaze(lst, maze);
        System.out.print(lst);
    }
    public static List<String> solveNMaze(List<String> lst, int[][] maze) {
        if(maze[0][0] == 0 || maze[maze.length-1][maze[0].length-1] == 0) {
            return lst;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        solve(0,0,new String(),visited,lst,maze);
        return lst;
    }
    public static void solve(int row, int col, String path,boolean[][] visited, List<String> ans, int[][] maze) {
        if(row == maze.length-1 && col == maze[0].length-1) {
            ans.add(path);
            return;
        }
        char[] dirs = {'D', 'R'};
        int[][] directions = {{1, 0},{0, 1}};
        for(int i=0;i<2;i++) {
            if(isSafe(row+directions[i][0],col+directions[i][1],visited,maze)) {
                visited[row+directions[i][0]][col+directions[i][1]] = true;
                solve(row+directions[i][0],col+directions[i][1],path+dirs[i],visited,ans,maze);
                visited[row+directions[i][0]][col+directions[i][1]] = false;
            }
        }
    }
    public static boolean isSafe(int row, int col, boolean[][] visited, int[][] maze) {
        return (row >= 0 && col >=0 && row<maze.length && col<maze[0].length && !visited[row][col] && maze[row][col] == 1);
    }
}
