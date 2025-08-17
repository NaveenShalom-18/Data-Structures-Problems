package Graph;

import java.util.*;

class BellmanFord {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    static void bellmanFord(int vertices, int edges, Edge[] edgeList, int src) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edgeList) {
                if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.src] + edge.weight;
                }
            }
        }

        for (Edge edge : edgeList) {
            if (distance[edge.src] != Integer.MAX_VALUE && distance[edge.src] + edge.weight < distance[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " -> " + (distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        Edge[] edgeList = new Edge[edges];

        System.out.println("Enter edges in format (src dest weight):");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edgeList[i] = new Edge(src, dest, weight);
        }

        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();

        bellmanFord(vertices, edges, edgeList, source);

        sc.close();
    }
}
