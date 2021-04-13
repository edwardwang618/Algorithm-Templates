package linear.array;

import java.util.Arrays;

public class TwoDPrefixSumArray {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}, {5, 6}};
        int[][] preSum = prefixSum(A);
        System.out.println(Arrays.deepToString(preSum));
        
        System.out.println(sumSubMatrix(preSum, 1, 0, 2, 1));
    }
    
    public static int[][] prefixSum(int[][] A) {
        int[][] preSum = new int[A.length + 1][A[0].length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                preSum[i + 1][j + 1] = A[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
        
        return preSum;
    }
    
    public static int sumSubMatrix(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
    }
}
