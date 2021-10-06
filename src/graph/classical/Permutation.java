package graph.classical;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] A = {1, 2, 3, 4, 5, 6};
        dfs(A, new boolean[A.length], new ArrayList<>(), res);
        System.out.println(res);
    }
    
    public static void dfs(int[] A, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == A.length) {
            res.add(new ArrayList<>(list));
            return;
        }
    
        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                list.add(A[i]);
                used[i] = true;
                dfs(A, used, list, res);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
