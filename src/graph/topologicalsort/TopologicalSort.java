package graph.topologicalsort;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int n = 6;
        Map<Integer, List<Integer>> g = new HashMap<>();
        g.put(0, List.of(1, 2, 3));
        g.put(1, List.of(4));
        g.put(2, List.of(4, 5));
        g.put(3, List.of(4, 5));
        
        System.out.println(bfsSort(n, g));
        System.out.println(dfsSort(n, g));
    }
    
    static List<Integer> bfsSort(int n, Map<Integer, List<Integer>> g) {
        Map<Integer, Integer> ind = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            for (int to : entry.getValue()) {
                ind.put(to, ind.getOrDefault(to, 0) + 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!ind.containsKey(i)) {
                q.offer(i);
                res.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (g.containsKey(cur)) {
                for (int to : g.get(cur)) {
                    ind.put(to, ind.get(to) - 1);
                    if (ind.get(to) == 0) {
                        q.offer(to);
                        res.add(to);
                    }
                }
            }
        }
        
        return res.size() == n ? res : new ArrayList<>();
    }
    
    static List<Integer> dfsSort(int n, Map<Integer, List<Integer>> g) {
        List<Integer> res = new ArrayList<>();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1 && dfs(i, g, vis, res)) {
                return new ArrayList<>();
            }
        }
        
        Collections.reverse(res);
        return res;
    }
    
    static boolean dfs(int cur, Map<Integer, List<Integer>> g, int[] vis, List<Integer> res) {
        vis[cur] = 0;
        if (g.containsKey(cur)) {
            for (int to : g.get(cur)) {
                if (vis[to] == 0 || vis[to] == -1 && dfs(to, g, vis, res)) {
                    return true;
                }
            }
        }
        
        vis[cur] = 1;
        res.add(cur);
        return false;
    }
}
