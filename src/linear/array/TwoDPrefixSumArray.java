package linear.array;

import java.util.Arrays;

public class TwoDPrefixSumArray {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}, {5, 6}};
        for (int[] row : A) {
            System.out.println(Arrays.toString(row));
        }
        int[][] preSum = prefixSum(A);
        System.out.println(Arrays.deepToString(preSum));
        
        System.out.println(sumSubMatrix(preSum, 1, 0, 2, 1));
        System.out.println(sumSubMatrix(preSum, 1, 1, 2, 1));
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
    
    // (x1, y1) is upper left, (x2, y2) is down right
    public static int sumSubMatrix(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
        // let x1 = x2 = x, y1 = y2 = y
        // preSum[x + 1][y + 1] - preSum[x + 1][y] - preSum[x][y + 1] + preSum[x][y] = A[x][y];
    }
}
