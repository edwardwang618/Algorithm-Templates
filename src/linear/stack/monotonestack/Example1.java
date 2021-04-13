package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Example1 {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 2, 0};
        System.out.println(Arrays.toString(getLastIndexSmallerThanCur(A)));
    }
    
    // Given an linear.array A, for each A[i], find the linear.array B such that
    // B[i] is the largest index that < i and A[B[i]] < A[i]. If
    // not found, define B[i] = -1
    public static int[] getLastIndexSmallerThanCur(int[] A) {
        int[] res = new int[A.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        
        return res;
    }
}
