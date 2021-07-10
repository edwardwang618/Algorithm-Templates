package linear.array;

import java.util.Arrays;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] preSum = prefixSum(A);
        System.out.println("preSum = " + Arrays.toString(preSum));
    
        // [0, 2]
        System.out.println(sumInterval(preSum, 0, 2));
        // [1, 3]
        System.out.println(sumInterval(preSum, 1, 3));
    }
    
    public static int[] prefixSum(int[] A) {
        // preSum[i] is the sum of A's prefix whose length is i
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        return preSum;
    }
    
    public static int sumInterval(int[] preSum, int l, int r) {
        return preSum[r + 1] - preSum[l];
    }
}
