package Graph;

import java.util.*;
class DFSTraversal {
    public static void dfs(char chararr[], int adjmatrix[][], int index, boolean visited[]) {
        visited[index] = true;
        System.out.print(chararr[index]+" ");
        for(int i=0;i<adjmatrix.length;i++) {
            if(adjmatrix[index][i] == 1 && !visited[i]) {
                dfs(chararr,adjmatrix,i,visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] chararr = new char[n];
        for(int i=0;i<n;i++) {
            chararr[i] = sc.next().charAt(0);
        }
        sc.nextLine();
        int edgesSize = sc.nextInt();
        int edges[][] = new int[edgesSize][2];
        for(int i=0;i<edgesSize;i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int adjmatrix[][] = new int[n][n];
        for(int i=0;i<edgesSize;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjmatrix[u][v] = 1;
        }
        boolean visited[] = new boolean[n];
        System.out.println("DFS Traversal Order:");
        dfs(chararr,adjmatrix,0,visited);
    }
}