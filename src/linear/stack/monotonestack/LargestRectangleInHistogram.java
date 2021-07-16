package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
    
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                int top = heights[stk.pop()];
                int l = stk.isEmpty() ? -1 : stk.peek();
                int r = i;
                res = Math.max(res, top * (r - l - 1));
            }
            
            stk.push(i);
        }
        
        while (!stk.isEmpty()) {
            int top = heights[stk.pop()];
            int l = stk.isEmpty() ? -1 : stk.peek();
            int r = n;
            res = Math.max(res, top * (r - l - 1));
        }
        
        return res;
    }
}


// [2, 1, 5, 6, 2, 3]
//
//
//         push index
//         push 0
//         [0,
//
//         att push 1, 2 >= 1,pop0,  look left -1 (index of the imaginary 0), look right 1
//         2 * (1 - (-1) - 1) = 2
//         [1
//
//
//         push 2  1 < 5
//         [1, 2,
//
//         push 3  5 < 6
//         [1, 2, 3
//
//         att push 4, 6 > 2
//         pop3, height = 6, look left  2, look right 4,   6 (4 - 2 - 1) = 6
//         pop2, height = 5, look left 1, look right 4   5 (4 - 1 -1)=10
//         [1, 4,
//
//         push 5
//         [1, 4, 5   [1, 2, 3
//         =================================================
//
//         looking at it
//         pop 5, look left 4, imaginary 0 in the right, look right is 6, 3*(6-4-1)=3
//         [1, 4

