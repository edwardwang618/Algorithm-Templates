package linear.array.sort;

import java.util.*;

public class QuickSortNonRecursion {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 10, 7};
        A = new int[10000000];
        for (int i = 0; i < A.length; i++) {
            A[i] = new Random().nextInt(1000000);
        }
        
        int[] A1 = Arrays.copyOf(A, A.length);
        Arrays.sort(A);
        
        // System.out.println(Arrays.toString(A));
        
        long prev = System.currentTimeMillis();
        quickSort(A1);
        long now = System.currentTimeMillis();
        // System.out.println(Arrays.toString(A1));
    
        System.out.println("now - prev = " + (now - prev));
        
        System.out.println(Arrays.equals(A, A1));
    }
    
    public static void quickSort(int[] A) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0, A.length - 1});
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int l = top[0], r = top[1];
            if (l >= r) {
                continue;
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
            
            stack.push(new int[]{i, r});
            stack.push(new int[]{l, j});
        }
    }
    
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}