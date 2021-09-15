package graph.classical;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] A = new int[26];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        
        long start = System.currentTimeMillis();
        dfs1(0, A, new ArrayList<>(), res);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    
        start = System.currentTimeMillis();
        dfs2(0, A, new ArrayList<>(), res);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    
    public static void dfs1(int start, int[] A, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < A.length; i++) {
            list.add(A[i]);
            dfs1(i + 1, A, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    static void dfs2(int u, int[] A, List<Integer> path, List<List<Integer>> res) {
        if (u == A.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        dfs2(u + 1, A, path, res);
        path.add(A[u]);
        dfs2(u + 1, A, path, res);
        path.remove(path.size() - 1);
    }
}
