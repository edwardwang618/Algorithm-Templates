package linear.deque.monotonequeue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Example1 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 3, 1, 0};
        System.out.println(Arrays.toString(slidingWindowMaximum(A, 2)));
    }
    
    public static int[] slidingWindowMaximum(int[] A, int size) {
        if (size > A.length) {
            throw new RuntimeException("Illegal size");
        }
        
        int[] res = new int[A.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - size) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= size - 1) {
                res[i - size + 1] = A[deque.peekFirst()];
            }
        }
        
        return res;
    }
}
