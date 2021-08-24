package linear.array.sort;

public class QuickSelect {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 10, 7};
        System.out.println(quickSelect(A, 1));
    }
    
    public static int quickSelect(int[] A, int idx) {
        return quickSelect(A, 0, A.length - 1, idx);
    }
    
    // find the A[idx] when A is sorted, or find the idx + 1'th smallest number
    private static int quickSelect(int[] A, int l, int r, int idx) {
        // partition
        int i = l, j = r;
        int piv = A[l + (r - l >> 1)];
        while (i <= j) {
            while (A[i] < piv) {
                i++;
            }
            while (A[j] > piv) {
                j--;
            }
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        
        // j < i  j < x < i
        // go left or go right
        if (idx <= j) {
            return quickSelect(A, l, j, idx);
        } else if (idx >= i) {
            return quickSelect(A, i, r, idx);
        } else {
            return A[idx];
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
