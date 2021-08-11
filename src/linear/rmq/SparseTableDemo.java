package linear.rmq;

public class SparseTableDemo {
    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 0};
        int[][] f = preProcess(A);
        System.out.println(query(f, 1, 4));
        System.out.println(query(f, 6, 7));
    }
    
    static int[][] preProcess(int[] nums) {
        int n = nums.length, t = (int) (Math.log(n) / Math.log(2) + 1);
        int[][] f = new int[n][t];
        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
        }
        
        for (int j = 1; j < t; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                f[i][j] = Math.max(f[i][j - 1], f[i + (1 << j - 1)][j - 1]);
            }
        }
        
        return f;
    }
    
    static int query(int[][] f, int l, int r) {
        int k = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.max(f[l][k], f[r - (1 << k) + 1][k]);
    }
}
