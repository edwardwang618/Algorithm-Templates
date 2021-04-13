package linear.array;

import java.util.Arrays;

public class TwoDDifferenceArray {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2},
                {3, 4},
                {5, 6}};
        int[][] diff = differenceArray(A);
        System.out.println(Arrays.deepToString(diff));
        
        add(diff, 0, 0, 1, 1, 3);
        System.out.println(Arrays.deepToString(restore(diff)));
    }
    
    public static int[][] differenceArray(int[][] A) {
        int[][] diff = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                add(diff, i, j, i, j, A[i][j]);
            }
        }
        
        return diff;
    }
    
    public static void add(int[][] diff, int x1, int y1, int x2, int y2, int z) {
        diff[x1][y1] += z;
        if (y2 + 1 < diff[0].length) {
            diff[x1][y2 + 1] -= z;
        }
        if (x2 + 1 < diff.length) {
            diff[x2 + 1][y1] -= z;
        }
        
        if (x2 + 1 < diff.length && y2 + 1 < diff[0].length) {
            diff[x2 + 1][y2 + 1] += z;
        }
    }
    
    public static int[][] restore(int[][] diff) {
        int[][] A = new int[diff.length][diff[0].length];
        for (int i = 0; i < diff.length; i++) {
            for (int j = 0; j < diff[0].length; j++) {
                A[i][j] = diff[i][j];
                if (i > 0) {
                    A[i][j] += A[i - 1][j];
                }
                if (j > 0) {
                    A[i][j] += A[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    A[i][j] -= A[i - 1][j - 1];
                }
            }
        }
        
        return A;
    }
}
