package linear.array.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 7, 10};
        int[] A1 = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        
        System.out.println(Arrays.toString(A));
        
        quickSort(A1);
        System.out.println(Arrays.toString(A1));
    }
    
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private static void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }
        
        // set a pivot, the best pivot is the median of A
        int piv = A[l + (r - l >> 1)];
        
        // partition
        int i = l, j = r;
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
        
        // sort the left half and right half
        quickSort(A, l, j);
        quickSort(A, i, r);
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
