package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeftClosestSmallerElement {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 2, 0};
        // B is an array, A[B[i]] is the closest smaller element left to A[i]
        // from i, look left, the index of the first smaller element
        // if not found, define it as -1
        
        // B =   [-1, 0, 1, 0, -1]
        
        // A = [3, 5, 6, 1, 2, 0]
        // B = [-1, 0, 1,-1,3, -1]
        System.out.println(Arrays.toString(getLastIndexSmallerThanCur(A)));
        System.out.println(Arrays.toString(solve(A)));
    }
    
    // 1 3 5 2 0
    //
    // maitain the stack is rigourously increasing from bottom to top
    //
    // whenever we push an element, the top is the answer for that element
    //
    //
    // push 1, stack is empty, so no answer, -1
    //         [1,
    //
    // push 3,  1 < 3, so the answer is ind of 1
    //         [1, 3
    //
    // push 5,  3 < 5, so the answer is ind of 3,
    //         [1, 3, 5
    //
    // push 2   5 >= 2, pop 5, 3 > 2, pop 3, 1 < 2, so the answer is ind of 1
    //         [1, 2
    //
    // push 0,  2 >= 0, pop 2, 1 > 0, pop 1, empty, so the answer is -1
    //         [
    
    
    // A = [3, 5, 6, 1, 2, 0]
    // push 3, stack empty, so no answer, -1
    //         [3
    //
    // push 5, 3 < 5, so ind of 3
    //         [3, 5
    //
    // push 6, 5 < 6, so ind of 5
    //         [3, 5, 6
    //
    // attempt to push 1, 6 >= 1, pop 6, 5 > 1, pop 5, 3 > 1, pop 3, empty, -1
    //         [1
    //
    // push 2, 1 < 2, ind of 1
    //         [1, 2
    //
    // att to push 0, 2 >= 0, pop 2, 1 > 0, pop 1, empty, -1
    //         [0
    
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
    
    // look left, find the closest less or equal, return the index
    public static int[] solve(int[] A) {
        int[] res = new int[A.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        
        return res;
    }
}
