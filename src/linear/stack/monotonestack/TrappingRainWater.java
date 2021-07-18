package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    public static int trap(int[] height) {
        Deque<Integer> stk = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[stk.peek()] <= height[i]) {
                int top = height[stk.pop()];
                int r = height[i];
                int l = stk.isEmpty() ? 0 : height[stk.peek()];
                res += Math.max(0, Math.min(l, r) - top) * (i - (stk.isEmpty() ? -1 : stk.peek()) - 1);
            }
            
            stk.push(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
