package linear.array.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 10, 7};
        int[] A1 = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        
        mergeSort(A1);
        System.out.println(Arrays.toString(A1));
    }
    
    public static void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }
    
    public static void mergeSort(int[] A, int l, int r) {
        mergeSort(A, l, r, new int[A.length]);
    }
    
    // sort A[l] to A[r], both ends included
    private static void mergeSort(int[] A, int l, int r, int[] tmp) {
        // exit case
        if (l >= r) {
            return;
        }
        
        // find the mid point(see it again in the binary search)
        int m = l + (r - l >> 1);
        // mergeSort the left half and right half
        mergeSort(A, l, m, tmp);
        mergeSort(A, m + 1, r, tmp);
        
        // merge
        int idx = l, i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (A[i] < A[j]) {
                tmp[idx++] = A[i++];
            } else {
                tmp[idx++] = A[j++];
            }
        }
        
        while (i <= m) {
            tmp[idx++] = A[i++];
        }
        
        while (j <= r) {
            tmp[idx++] = A[j++];
        }
        
        // copy back to A
        for (i = l; i <= r; i++) {
            A[i] = tmp[i];
        }
    }
}
