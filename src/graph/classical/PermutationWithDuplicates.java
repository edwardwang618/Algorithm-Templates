package graph.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicates {
    public static void main(String[] args) {
        int[] A = {2, 2, 1};
        
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        dfs(A, new boolean[A.length], new ArrayList<>(), res);
        System.out.println(res);
    }
    
    public static void dfs(int[] A, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == A.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1] && !used[i - 1]) {
                continue;
            }
            
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
