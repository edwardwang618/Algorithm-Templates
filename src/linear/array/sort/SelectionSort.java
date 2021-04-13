package linear.array.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 5, 2};
        selectionSort(A);
        System.out.println(Arrays.toString(A));
    }
    
    public static void selectionSort(int[] A) {
        for (int i = 0; i + 1 < A.length; i++) {
            int idx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[idx]) {
                    idx = j;
                }
            }
            
            swap(A, idx, i);
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
