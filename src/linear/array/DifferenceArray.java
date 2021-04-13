package linear.array;

import java.util.Arrays;

public class DifferenceArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 0, 3, -1};
        int[] diff = diffArr(A), diff2 = difArr2(A);
        System.out.println(Arrays.equals(diff, diff2));
    
        System.out.println(Arrays.toString(diff));
    
        int[] orig = restore(diff);
        System.out.println(Arrays.toString(orig));
        System.out.println(Arrays.equals(orig, A));
        
        add(diff, 0, 2, 2);
        add(diff, 1, 3, 3);
    
        System.out.println(Arrays.toString(diff));
        System.out.println(Arrays.toString(restore(diff)));
    }
    
    static int[] diffArr(int[] A) {
        int[] diff = new int[A.length];
        diff[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            diff[i] = A[i] - A[i - 1];
        }
        
        return diff;
    }
    
    static int[] difArr2(int[] A) {
        int[] diff = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            add(diff, i, i, A[i]);
        }
        
        return diff;
    }
    
    static void add(int[] diff, int l, int r, int x) {
        diff[l] += x;
        if (r + 1 < diff.length) {
            diff[r + 1] -= x;
        }
    }
    
    static int[] restore(int[] diff) {
        int[] A = new int[diff.length];
        A[0] = diff[0];
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i - 1] + diff[i];
        }
        
        return A;
    }
}
