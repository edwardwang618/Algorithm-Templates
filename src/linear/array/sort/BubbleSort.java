package linear.array.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {4, 1, 3, 5, 2};
        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }
    
    public static void bubbleSort(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    sorted = false;
                }
            }
            
            if (sorted) {
                return;
            }
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
