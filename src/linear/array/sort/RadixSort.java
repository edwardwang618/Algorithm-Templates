package linear.array.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = rand.nextInt(1000);
        }
        
        System.out.println(Arrays.toString(A));
        radix_sort(A);
        System.out.println(Arrays.toString(A));
    }
    
    static void radix_sort(int[] A) {
        Queue<Integer>[] qs = (Queue<Integer>[]) new ArrayDeque[10];
        for (int i = 0; i < 10; i++) {
            qs[i] = new ArrayDeque<>();
        }
        
        int base = 1;
        while (qs[0].size() < A.length) {
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                while (!qs[i].isEmpty()) {
                    A[idx++] = qs[i].poll();
                }
            }
            
            for (int x : A) {
                qs[x / base % 10].add(x);
            }
            
            base *= 10;
        }
        
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            while (!qs[i].isEmpty()) {
                A[idx++] = qs[i].poll();
            }
        }
    }
}
