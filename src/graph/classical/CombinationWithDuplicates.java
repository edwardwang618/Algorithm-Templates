package graph.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithDuplicates {
    public static void main(String[] args) {
        int[] A = {2, 2, 1};
        Arrays.sort(A);
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, A, new boolean[A.length], new ArrayList<>(), res);
        System.out.println(res);
    }
    
    public static void dfs(int start, int[] A, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < A.length; i++) {
            if (i > start && A[i] == A[i - 1] && !used[i - 1]) {
                continue;
            }
            
            if (!used[i]) {
                list.add(A[i]);
                used[i] = true;
                dfs(i + 1, A, used, list, res);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
