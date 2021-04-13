package linear.array.sort;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    
    static Random random = new Random();
    
    public static void main(String[] args) {
        int size = 5000000;
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = random.nextInt(100);
        }
        
        int[] A1 = Arrays.copyOf(A, A.length);
        int[] A2 = Arrays.copyOf(A, A.length);
        long prev = System.currentTimeMillis();
        QuickSort.quickSort(A);
        long end = System.currentTimeMillis();
        
        System.out.println("end - prev = " + (end - prev));
        prev = System.currentTimeMillis();
        ImprovedQuickSort.quickSort(A1);
        end = System.currentTimeMillis();
        
        System.out.println("end - prev = " + (end - prev));
    
    
        prev = System.currentTimeMillis();
        Arrays.sort(A2);
        end = System.currentTimeMillis();
    
        System.out.println(Arrays.equals(A, A1));
        System.out.println(Arrays.equals(A, A2));
        
    }
}
