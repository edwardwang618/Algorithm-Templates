package linear.array.sort;

public class NumberOfInversionPairs {
    public static void main(String[] args) {
        int[] A = {7, 10, 3};
        System.out.println(mergeSort(A));
    }
    
    public static int mergeSort(int[] A) {
        return mergeSort(A, 0, A.length - 1, new int[A.length]);
    }
    
    // returns how many inversion pairs in A[l, ..., r] and at the same time sort A[l: r]
    private static int mergeSort(int[] A, int l, int r, int[] tmp) {
        // base case
        if (l >= r) {
            return 0;
        }
        
        int m = l + (r - l >> 1);
        int res = 0;
        res += mergeSort(A, l, m, tmp);
        res += mergeSort(A, m + 1, r, tmp);
        
        int i = l, j = m + 1, idx = l;
        while (i <= m && j <= r) {
            if (A[i] > A[j]) {
                res += m - i + 1;
                tmp[idx++] = A[j++];
            } else {
                tmp[idx++] = A[i++];
            }
        }
        
        while (i <= m) {
            tmp[idx++] = A[i++];
        }
        while (j <= r) {
            tmp[idx++] = A[j++];
        }
        
        for (i = l; i <= r; i++) {
            A[i] = tmp[i];
        }
        
        return res;
    }
}
