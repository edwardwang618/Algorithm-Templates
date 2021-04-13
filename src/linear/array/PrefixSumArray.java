package linear.array;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] preSum = prefixSum(A);
        
        System.out.println(sumInterval(preSum, 0, 2));
    }
    
    public static int[] prefixSum(int[] A) {
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
