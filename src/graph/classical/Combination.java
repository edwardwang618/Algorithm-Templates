package graph.classical;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] A = {1, 2, 3};
        dfs(0, A, new ArrayList<>(), res);
        System.out.println(res);
    }
    
    public static void dfs(int start, int[] A, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < A.length; i++) {
            list.add(A[i]);
            dfs(i + 1, A, list, res);
            list.remove(list.size() - 1);
        }
    }
}
