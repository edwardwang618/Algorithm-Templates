package graph.shortestpath.weighted;

import java.util.Arrays;

public class Dijkstra1 {
    public static void main(String[] args) {
        int n = 7;
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        
        graph[0][1] = 1;
        graph[0][2] = 2;
        graph[0][3] = 4;
        graph[1][0] = 1;
        graph[1][3] = 3;
        graph[4][5] = 5;
        graph[4][6] = 2;
        graph[4][3] = 3;
        graph[3][4] = 1;
        
        int[] dist = new int[n];
        dijkstra1(0, dist, graph);
        System.out.println(Arrays.toString(dist));
    }
    
    public static void dijkstra1(int cur, int[] dist, int[][] graph) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[cur] = 0;
        
        boolean[] visited = new boolean[dist.length];
        for (int i = 0; i < dist.length; i++) {
            int min = Integer.MAX_VALUE, v = 0;
            for (int j = 0; j < dist.length; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    v = j;
                }
            }
            
            visited[v] = true;
            for (int j = 0; j < graph[v].length; j++) {
                if (graph[v][j] == Integer.MAX_VALUE) {
                    continue;
                }
                
                if (!visited[j] && dist[j] > dist[v] + graph[v][j]) {
                    dist[j] = dist[v] + graph[v][j];
                }
            }
        }
    }
}
