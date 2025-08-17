package Graph;

import java.util.*;

public class EulerPathEulerCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.putIfAbsent(u,new ArrayList<>());
            graph.putIfAbsent(v,new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int cnt = 0;
        if(detectCycle(graph, cnt) == 0) {
            System.out.print("Euler Cycle: ");
        }
        else if(detectCycle(graph, cnt) == 2) {
            System.out.print("Euler Path: ");
        }
        else {
            System.out.print("Not Eulerian");
        }
        int start = startVertex(graph);
        List<Integer> path = new ArrayList<>();
        dfs(start,graph,path);
        Collections.reverse(path);
        for(int i : path) {
            System.out.print(i+" ");
        }

    }

    public static void remove(int u,int v,Map<Integer,List<Integer>> graph) {
        graph.get(u).remove((Integer) v);
        graph.get(v).remove((Integer) u);
    }

    public static void dfs(int start,Map<Integer,List<Integer>> graph,List<Integer> path) {
        while(!graph.get(start).isEmpty()) {
            int v = graph.get(start).get(0);
            remove(start,v, graph);
            dfs(v,graph,path);
        }
        path.add(start);
    }

    public static int startVertex(Map<Integer,List<Integer>> graph) {
         for(int edge : graph.keySet()) {
             if(graph.get(edge).size()%2 != 0) {
                 return edge;
             }
         }
         return graph.keySet().iterator().next();
    }

    public static int detectCycle(Map<Integer,List<Integer>> graph, int cnt) {
        for(int vertex : graph.keySet()) {
            if(graph.get(vertex).size()%2 != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
