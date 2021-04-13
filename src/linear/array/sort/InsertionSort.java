package linear.array.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 5, 2};
        insertionSort(A);
        System.out.println(Arrays.toString(A));
    }
    
    public static void insertionSort(int[] A) {
        for (int i = 1, j = 0; i < A.length; i++) {
            int tmp = A[i];
            for (j = i; j > 0 && A[j - 1] > tmp; j--) {
                A[j] = A[j - 1];
            }
            
            A[j] = tmp;
        }
    }
}
