package linear.array.sort;

import java.util.Arrays;
import java.util.Random;

public class ImprovedQuickSort {
    
    static Random random = new Random();
    
    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 10, 7, 5};
        int size = 100;
        A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = random.nextInt(100);
        }
        
        int[] A1 = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        
        System.out.println(Arrays.toString(A));
        
        quickSort(A1);
        System.out.println(Arrays.toString(A1));
    
        System.out.println(Arrays.equals(A, A1));
    }
    
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private static void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int piv = A[l + (r - l >> 1)];
        int i = l, j = l, k = r;
        while (j <= k) {
            if (A[j] < piv) {
                swap(A, i++, j++);
            } else if (A[j] > piv) {
                swap(A, j, k--);
            } else {
                j++;
            }
        }
        
        quickSort(A, l, i - 1);
        quickSort(A, k + 1, r);
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
